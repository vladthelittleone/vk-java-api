package vk.java.api.persistence.sharding;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class HibernateShardingDaoSupport extends HibernateDaoSupport
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
