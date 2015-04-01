package vk.java.api.persistence.dao;

import vk.java.api.persistence.domain.Sequence;

/**
 * @author Skurishin Vladislav
 * @since 30.03.15
 */
public interface SequenceDao
{
    /**
     * Add new sequence.
     *
     * @param sequence new sequence with
     * @return id of sequence
     * @see vk.java.api.persistence.sharding.DataSourceBinding
     */
    Long add(Sequence sequence);

    /**
     * Get next sequence value.
     * @param bindingName sequence binding name
     * @return sequence next value
     */
    long getNextValue(String bindingName);
}
