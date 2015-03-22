package vk.java.api.persistence.sharding;

import org.springframework.util.Assert;

/**
 * @author Skurishin Vladislav
 * @since 22.03.15
 */
public class ShardingDaoSupport
{
    private static final ThreadLocal<String> dataSourceNameHolder = new ThreadLocal<>();

    public static void setDataSourceName(String name)
    {
        Assert.notNull(name, "Data source name can't be null");
        dataSourceNameHolder.set(name);
    }

    public static String getDataSourceName()
    {
        return dataSourceNameHolder.get();
    }

    public static void clearDataSourceName()
    {
        dataSourceNameHolder.remove();
    }
}
