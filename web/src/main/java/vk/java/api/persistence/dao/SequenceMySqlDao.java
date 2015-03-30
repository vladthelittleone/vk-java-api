package vk.java.api.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vk.java.api.persistence.sharding.DataSourceBinding;
import vk.java.api.persistence.sharding.ShardingContextHolder;

import javax.transaction.Transactional;
import java.math.BigInteger;

/**
 * @author Skurishin Vladislav
 * @since 30.03.15
 */
@Transactional
public class SequenceMySqlDao extends AbstractDaoSupport implements SequenceDao
{
    public SequenceMySqlDao(DataSourceBinding binding, SessionFactory sessionFactory)
    {
        bindingName = binding.getBindingName();
        setSessionFactory(sessionFactory);
    }

    @Override
    public long getNexValue()
    {
        ShardingContextHolder.set(getBindingName(), 0L);

        String INCREMENT_SQL = "UPDATE sequence SET ID = LAST_INSERT_ID(ID + 1)";
        String LAST_INSERT_ID_SQL = "SELECT LAST_INSERT_ID()";

        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        session.createSQLQuery(INCREMENT_SQL).executeUpdate();

        // Return last insert id. Imitate sequence.
        return ((BigInteger) session.createSQLQuery(LAST_INSERT_ID_SQL)
                .uniqueResult()).longValue();
    }
}
