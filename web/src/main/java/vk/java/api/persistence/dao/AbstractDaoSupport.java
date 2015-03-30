package vk.java.api.persistence.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import vk.java.api.persistence.domain.Person;
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

        Criteria criteria = getSessionFactory().getCurrentSession()
                .createCriteria(Person.class)
                .setProjection(Projections.max("PERSON_ID"));

        return (Long) criteria.uniqueResult() + 1;
    }
}
