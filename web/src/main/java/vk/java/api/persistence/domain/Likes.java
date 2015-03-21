package vk.java.api.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * package: vk.java.api.persistance.domain
 * date: 11.03.15
 *
 * @author Skurishin Vladislav
 */
@Entity
@Table(name = "LIKES")
public class Likes implements Serializable
{
    private static final long serialVersionUID = 2L;

    private Long likesId;
    private Long personId;
    private Long amount;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "LIKES_ID")
    public Long getLikesId()
    {
        return likesId;
    }

    public void setLikesId(Long likesId)
    {
        this.likesId = likesId;
    }

    @Column(name = "PERSON_ID")
    public Long getPersonId()
    {
        return personId;
    }

    public void setPersonId(Long personId)
    {
        this.personId = personId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }
}
