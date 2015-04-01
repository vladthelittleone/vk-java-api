package vk.java.api.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import vk.java.api.persistence.domain.Person;

import javax.transaction.Transactional;

/**
 * package: vk.java.api.persistence.dao
 * date: 09.03.15
 *
 * @author Skurishin Vladislav
 */
@Transactional
public class PersonMySqlDao extends HibernateDaoSupport implements PersonDao
{
    public PersonMySqlDao(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

    @Override
    public Person get(Long id)
    {

        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Get
        return (Person) session.get(Person.class, id);
    }

    @Override
    public Long add(Person person)
    {
        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Save
        return (Long) session.save(person);
    }
}
