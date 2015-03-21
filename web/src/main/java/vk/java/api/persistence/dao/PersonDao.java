package vk.java.api.persistence.dao;

import vk.java.api.persistence.domain.Person;

/**
 * package: vk.java.api.persistance.dao
 * date: 09.03.15
 *
 * @author Skurishin Vladislav
 */
public interface PersonDao
{
    /**
     * Возвращает информацию об человеке с заданным id.
     */
    public Person get(Long id);

    /**
     * Добавляем нового человека
     */
    public Long add(Person person);
}
