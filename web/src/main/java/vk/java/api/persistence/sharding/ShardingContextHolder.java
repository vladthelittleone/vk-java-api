package vk.java.api.persistence.sharding;

import org.springframework.util.Assert;

/**
 * @author Skurishin Vladislav
 * @since 22.03.15
 */
public class ShardingContextHolder
{
    private static final ThreadLocal<String> bindingNameHolder = new ThreadLocal<>();
    private static final ThreadLocal<Object> key = new ThreadLocal<>();

    public static void set(String bindingName, Long k)
    {
        Assert.notNull(bindingName, "Data source name can't be null");
        Assert.notNull(k, "Key can't be null");
        bindingNameHolder.set(bindingName);
        key.set(k);
    }

    public static void setBindingName(String bindingName)
    {
        Assert.notNull(bindingName, "Data source name can't be null");
        bindingNameHolder.set(bindingName);
    }

    public static String getBindingName()
    {
        return bindingNameHolder.get();
    }

    public static void clearBindingName()
    {
        bindingNameHolder.remove();
    }

    public static void setKey(Long k)
    {
        Assert.notNull(k, "Key can't be null");
        key.set(k);
    }

    public static Object getKey()
    {
        return key.get();
    }

    public static void clearKey()
    {
        key.remove();
    }
}
