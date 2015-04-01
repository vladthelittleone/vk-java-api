package vk.java.api.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Skurishin Vladislav
 * @since 30.03.15
 */
@Entity
@Table(name = "SEQUENCE")
public class Sequence
{
    private Long id;
    private Long sequence;
    private String name;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    public Long getId()
    {
        return id;
    }

    public Sequence setId(Long id)
    {
        this.id = id;
        return this;
    }

    @Column(name = "NAME")
    public String getName()
    {
        return name;
    }

    public Sequence setName(String name)
    {
        this.name = name;
        return this;
    }

    @Column(name = "SEQUENCE")
    public Long getSequence()
    {
        return sequence;
    }

    public Sequence setSequence(Long sequence)
    {
        this.sequence = sequence;
        return this;
    }
}
