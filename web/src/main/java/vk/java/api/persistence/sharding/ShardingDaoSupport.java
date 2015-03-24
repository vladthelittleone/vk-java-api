package vk.java.api.persistence.sharding;

import com.sun.istack.internal.NotNull;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class ShardingDaoSupport
{
    @NotNull
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
