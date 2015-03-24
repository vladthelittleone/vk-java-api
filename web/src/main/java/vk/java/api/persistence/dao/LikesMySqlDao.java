package vk.java.api.persistence.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import vk.java.api.persistence.domain.Likes;

import javax.transaction.Transactional;
import java.util.List;

/**
 * package: vk.java.api.persistence.dao
 * date: 11.03.15
 *
 * @author Skurishin Vladislav
 */
@Transactional
public class LikesMySqlDao extends HibernateDaoSupport implements LikesDao
{

    @Override
    public Likes get(Long id)
    {

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();

       // List like = session.createSQLQuery("SELECT * FROM likes WHERE likes.PERSON_ID = " + id)
             //   .addEntity(Likes.class).list();

        Query query = session.createSQLQuery("SELECT * FROM likes WHERE likes.PERSON_ID like :id " ).addEntity(Likes.class);
        List result = query.setLong("id",id).list();
        //Возвращаем информацию о лайках  конкретного пользоватяля
       // return (Likes) like.get(0);
        return (Likes) result.get(0);
    }

    @Override
    public int increaseLikeAmount(Long id)
    {
        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery("UPDATE likes SET likes.AMOUNT = likes.AMOUNT + 1 where likes.PERSON_ID = " + id);
        int result = query.executeUpdate();

        return result;
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
