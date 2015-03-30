package vk.java.api.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Skurishin Vladislav
 * @since 30.03.15
 */
@Entity
public class Sequence
{
    @Id
    @GenericGenerator(name = "table", strategy = "enhanced-table", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence", value = "sequence_table")
    })
    @GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
    private Long id;
}
