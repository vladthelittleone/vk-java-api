package vk.java.api.persistence.dao;

import vk.java.api.persistence.domain.Person;

/**
 * package: vk.java.api.persistence.dao
 * date: 09.03.15
 *
 * @author Skurishin Vladislav
 */
public interface PersonDao
{
    /**
     * Return information about person with {@code id}, using hessian session.
     */
    public Person get(Long id);

    /**
     * Добавляем нового человека
     */
    public Long add(Person person);
}
