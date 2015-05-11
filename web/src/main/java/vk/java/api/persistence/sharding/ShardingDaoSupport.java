package vk.java.api.persistence.sharding;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class ShardingDaoSupport
{
    protected String bindingName;

    public String getBindingName()
    {
        return bindingName;
    }

    public void setBindingName(String bindingName)
    {
        this.bindingName = bindingName;
    }
}
