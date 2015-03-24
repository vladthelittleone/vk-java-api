package vk.java.api.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vk.java.api.persistence.domain.Person;
import vk.java.api.persistence.sharding.DataSourceBinding;
import vk.java.api.persistence.sharding.ShardingContextHolder;

import javax.transaction.Transactional;

/**
 * package: vk.java.api.persistence.dao
 * date: 09.03.15
 *
 * @author Skurishin Vladislav
 */
@Transactional
public class PersonMySqlDao extends AbstractDaoSupport implements PersonDao
{
    public PersonMySqlDao(DataSourceBinding binding, SessionFactory sessionFactory)
    {
        bindingName = binding.getBindingName();
        setSessionFactory(sessionFactory);
    }

    /**
     * Возвращает информацию об человеке с заданным id, используя сессию hibernate.
     */
    public Person get(Long id)
    {
        ShardingContextHolder.set(getBindingName(), id);

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Retrieve existing person first
        return (Person) session.get(Person.class, id);
    }

    /**
     * Добавляем нового человека, используя сессию hibernate.
     */
    public Long add(Person person)
    {
        Long id = getNext(bindingName);

        ShardingContextHolder.set(getBindingName(), id);

        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Save
        return (Long) session.save(person);
    }
}
