package vk.java.api.persistence.dao;

import org.hibernate.Query;
import org.hibernate.type.StandardBasicTypes;
import vk.java.api.persistence.sharding.HibernateShardingDaoSupport;
import vk.java.api.persistence.sharding.ShardingContextHolder;

/**
 * @author Skurishin Vladislav
 * @since 24.03.15
 */
public class AbstractDaoSupport extends HibernateShardingDaoSupport
{
    Long getNext(String sequence)
    {
        ShardingContextHolder.set(getBindingName(), 0L);

        String SEQ_SQL = String.format("SELECT %s.nextval AS num FROM person", sequence);

        Query query = getSessionFactory().getCurrentSession().createSQLQuery(SEQ_SQL)
                .addScalar("num", StandardBasicTypes.LONG);

        return (Long) query.uniqueResult();
    }
}
