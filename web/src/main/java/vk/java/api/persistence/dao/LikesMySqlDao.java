package vk.java.api.persistence.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vk.java.api.persistence.domain.Likes;
import vk.java.api.persistence.sharding.DataSourceBinding;

import javax.transaction.Transactional;

/**
 * package: vk.java.api.persistence.dao
 * date: 11.03.15
 *
 * @author Skurishin Vladislav
 */
@Transactional
public class LikesMySqlDao extends AbstractDaoSupport implements LikesDao
{
    public LikesMySqlDao(DataSourceBinding binding, SessionFactory sessionFactory)
    {
        bindingName = binding.getBindingName();
        setSessionFactory(sessionFactory);
    }

    @Override
    public Likes get(Long id)
    {
        String GET_SQL = "SELECT * FROM likes WHERE likes.PERSON_ID LIKE :id ";

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();

        Query query = session.createSQLQuery(GET_SQL).addEntity(Likes.class);

        //Возвращаем информацию о лайках  конкретного пользоватяля
        return (Likes) query.setLong("id", id).uniqueResult();
    }

    @Override
    public int increaseLikeAmount(Long id)
    {
        String INC_SQL = "UPDATE likes SET likes.AMOUNT = likes.AMOUNT + 1 where likes.PERSON_ID = :id ";

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery(INC_SQL).setLong("id", id);

        return query.executeUpdate();
    }

    @Override
    public Long add(Likes like)
    {
        // Retrieve session from Hibernate
        Session session = getSessionFactory().getCurrentSession();

        // Save
        return (Long) session.save(like);
    }

}
