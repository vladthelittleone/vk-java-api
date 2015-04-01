package vk.java.api.persistence.dao;

import vk.java.api.persistence.domain.Likes;

import java.io.Serializable;

/**
 * package: vk.java.api.persistence.dao
 * date: 11.03.15
 *
 * @author Skurishin Vladislav
 */
public interface LikesDao
{
    /**
     * Get information about likes with {@code id}.
     */
    public Likes get(Long id);

    /**
     * Increase likes amount.
     */
    public int increaseLikesAmount(Long id);

    /**
     * Add new likes row.
     */
    public Serializable add(Likes like);
}
