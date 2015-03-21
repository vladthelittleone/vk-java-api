package vk.java.api.persistence.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
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
    /**
     * Возвращает информацию об человеке с заданным id, используя сессию hibernate.
     */
    public Person get(Long id)
    {
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
        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Save
        return (Long) session.save(person);
    }
}
