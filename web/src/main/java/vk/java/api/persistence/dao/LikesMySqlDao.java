package vk.java.api.persistence.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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
}
