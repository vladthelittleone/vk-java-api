package vk.java.api.persistence.sharding;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * @author Skurishin Vladislav
 * @since 22.03.15
 */
public class DataSourceBinding
{
    private final Collection<DataSource> dataSources;

    private final String bindingName;

    public DataSourceBinding(String bindingName, Collection<DataSource> dataSources)
    {
        this.dataSources = dataSources;
        this.bindingName = bindingName;
    }

    public Collection<DataSource> getDataSources()
    {
        return dataSources;
    }

    public String getBindingName()
    {
        return bindingName;
    }
}
