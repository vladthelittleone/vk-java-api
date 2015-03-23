package vk.java.api.persistence.sharding;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class DefaultDistributionStrategy implements DistributionStrategy
{
    @Override
    public DataSource distribute(Object key, Collection<DataSource> dataSources)
    {
        if (dataSources.isEmpty())
        {
            throw new IllegalArgumentException("Data sources");
        }

        return (DataSource) dataSources.toArray()[key.hashCode() / 2];
    }
}
