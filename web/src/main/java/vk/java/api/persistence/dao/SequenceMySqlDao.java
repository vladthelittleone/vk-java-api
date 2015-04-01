package vk.java.api.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import vk.java.api.persistence.domain.Sequence;

import javax.transaction.Transactional;

/**
 * @author Skurishin Vladislav
 * @since 30.03.15
 */
@Transactional
public class SequenceMySqlDao extends HibernateDaoSupport implements SequenceDao
{
    public SequenceMySqlDao(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

    @Override
    public Long add(Sequence sequence)
    {
        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Save
        return (Long) session.save(sequence);
    }

    @Override
    public long getNextValue(String bindingName)
    {
        String INC_SQL = "UPDATE sequence SET sequence = sequence + 1 WHERE name = :name ";

        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        Query query = session.createSQLQuery(INC_SQL).setString("name", bindingName);

        // Get next value of sequence.
        return query.executeUpdate();
    }
}
