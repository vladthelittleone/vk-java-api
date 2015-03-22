package vk.java.api.persistence.sharding;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Collection;

/**
 * @author Skurishin Vladislav
 * @since 22.03.15
 */
public class ShardingDataSource extends AbstractRoutingDataSource
{
    private Collection<DataSourceBinding> dataSourceBindings;

    @Override
    protected Object determineCurrentLookupKey()
    {
        return new Object();
    }

    public ShardingDataSource(Collection<DataSourceBinding> dataSourceBindings)
    {
        this.dataSourceBindings = dataSourceBindings;
    }

    public Collection<DataSourceBinding> getDataSourceBindings()
    {
        return dataSourceBindings;
    }

    public void setDataSourceBindings(Collection<DataSourceBinding> dataSourceBindings)
    {
        this.dataSourceBindings = dataSourceBindings;
    }
}
