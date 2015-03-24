package vk.java.api.persistence.sharding;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private final Collection<DataSourceBinding> dataSourceBindings;

    @NotNull
    private final DistributionStrategy strategy;

    @NotNull
    private final AbstractRoutingDataSource routingDelegate;

    public ShardingDataSource(Collection<DataSourceBinding> dataSourceBindings, DistributionStrategy strategy)
    {
        this.dataSourceBindings = dataSourceBindings;
        this.strategy = strategy;

        routingDelegate = new RoutingDataSource();

        Map<Object, Object> m = new HashMap<>();

        for (DataSourceBinding binding : dataSourceBindings)
        {
            for (DataSource dataSource : binding.getDataSources())
            {
                m.put(dataSource.toString(), dataSource);
            }
        }

        routingDelegate.setTargetDataSources(m);
        routingDelegate.afterPropertiesSet();
        setTargetDataSource(routingDelegate);
    }

    public ShardingDataSource(Collection<DataSourceBinding> dataSourceBindings, DistributionStrategy strategy,
                              DataSource defaultDataSource)
    {
        this.dataSourceBindings = dataSourceBindings;
        this.strategy = strategy;

        routingDelegate = new RoutingDataSource();

        Map<Object, Object> m = new HashMap<>();

        for (DataSourceBinding binding : dataSourceBindings)
        {
            for (DataSource dataSource : binding.getDataSources())
            {
                m.put(dataSource.toString(), dataSource);
            }
        }

        routingDelegate.setTargetDataSources(m);
        routingDelegate.setDefaultTargetDataSource(defaultDataSource);
        routingDelegate.afterPropertiesSet();

        setTargetDataSource(routingDelegate);
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
