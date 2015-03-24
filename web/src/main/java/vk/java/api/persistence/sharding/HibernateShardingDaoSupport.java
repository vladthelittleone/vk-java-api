package vk.java.api.persistence.sharding;

import com.sun.istack.internal.NotNull;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class HibernateShardingDaoSupport extends HibernateDaoSupport
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
