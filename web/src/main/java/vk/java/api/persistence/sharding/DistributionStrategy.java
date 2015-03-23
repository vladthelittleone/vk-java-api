package vk.java.api.persistence.sharding;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * @author Skurishin Vladislav
 * @since 23.03.15
 */
public interface DistributionStrategy
{
    DataSource distribute(Object key, Collection<DataSource> dataSources);
}
