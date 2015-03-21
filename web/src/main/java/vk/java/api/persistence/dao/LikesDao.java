package vk.java.api.persistence.dao;

import vk.java.api.persistence.domain.Likes;

/**
 * package: vk.java.api.persistence.dao
 * date: 11.03.15
 *
 * @author Skurishin Vladislav
 */
public interface LikesDao
{
    /**
     * Возвращает информацию о лайках  с заданным id.
     */
    public Likes get(Long id);

    /**
     * Добавляем новую информацию о лайках человека
     * @param like
     * @return
     */
    public Long add(Likes like);
}
