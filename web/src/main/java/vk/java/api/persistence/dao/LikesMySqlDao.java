package vk.java.api.persistence.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import vk.java.api.persistence.domain.Likes;

import javax.transaction.Transactional;

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
    public Likes get(Long id) {

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();

        //Возвращаем информацию о лайках
        return (Likes) session.get(Likes.class,id);
    }

    @Override
    public Long add(Likes like) {

        // Получаем сессию hibernate
        Session session = getSessionFactory().getCurrentSession();

        //Сохраняем новую информацию
        return (Long) session.save(like) ;
    }
}
