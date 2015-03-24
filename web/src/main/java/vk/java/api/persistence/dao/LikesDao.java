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
     * Изменяем информацию о лайках человека
     */
    public int increaseLikeAmount(Long id);

    /**
     * Добавляем новую запись о лайках человека
     */
    public Long add(Likes like);
}
