package vk.java.api.persistence.sharding;

import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Skurishin Vladislav
 * @since 22.03.15
 */
public class ShardingDataSource extends DelegatingDataSource
{
    private final Collection<DataSourceBinding> dataSourceBindings;
    private final DistributionStrategy strategy;

    public ShardingDataSource(Collection<DataSourceBinding> dataSourceBindings, DistributionStrategy strategy)
    {
        this.dataSourceBindings = dataSourceBindings;
        this.strategy = strategy;

        AbstractRoutingDataSource targetDataSource = new RoutingDataSource();

        Map<Object, Object> m = new HashMap<>();

        for (DataSourceBinding binding : dataSourceBindings)
        {
            for (DataSource dataSource : binding.getDataSources())
            {
                m.put(dataSource.toString(), dataSource);
            }
        }

        targetDataSource.setTargetDataSources(m);
        setTargetDataSource(targetDataSource);
    }

    private class RoutingDataSource extends AbstractRoutingDataSource
    {
        @Override
        protected Object determineCurrentLookupKey()
        {
            String bindingName = ShardingContextHolder.getBindingName();
            Object key = ShardingContextHolder.getKey();

            for (DataSourceBinding binding : dataSourceBindings)
            {
                if (binding.getBindingName().equals(bindingName))
                {
                    Collection<DataSource> dataSources = binding.getDataSources();
                    return strategy.distribute(key, dataSources).toString();
                }
            }

            // Возвращаем null, если DataSource не найдена.
            return null;
        }
    }
}
