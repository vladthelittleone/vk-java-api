package vk.java.api.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * package: vk.java.api.persistance.domain
 * date: 06.03.15
 *
 * @author Skurishin Vladislav
 *
 * TODO
 * Нужен билдер для pojo классов.
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long personId;
    private Long sex;

    private String firstName;
    private String lastName;
    private String birthday;
    private String photo;
    private String nickName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person()
    {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "PERSON_ID")
    public Long getPersonId()
    {
        return personId;
    }

    public void setPersonId(Long personId)
    {
        this.personId = personId;
    }

    @Column(name = "LAST_NAME")
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Column(name = "SEX")
    public Long getSex()
    {
        return sex;
    }

    public Person setSex(Long set)
    {
        this.sex = set;
        return this;
    }

    @Column(name = "B_DATE")
    public String getBirthday()
    {
        return birthday;
    }

    public Person setBirthday(String birthday)
    {
        this.birthday = birthday;
        return this;
    }

    @Column(name = "PHOTO")
    public String getPhoto()
    {
        return photo;
    }

    public Person setPhoto(String photo)
    {
        this.photo = photo;
        return this;
    }

    @Column(name = "NICKNAME")
    public String getNickName()
    {
        return nickName;
    }

    public Person setNickName(String nickName)
    {
        this.nickName = nickName;
        return this;
    }
}
