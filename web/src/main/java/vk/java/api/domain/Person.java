package vk.java.api.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * package: vk.java.api.domain
 * date: 06.03.15
 *
 * @author Skurishin Vladislav
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer personId;
    private Integer sex;

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
    public Integer getPersonId()
    {
        return personId;
    }

    public void setPersonId(Integer personId)
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
    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer set)
    {
        this.sex = set;
    }

    @Column(name = "B_DATE")
    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    @Column(name = "PHOTO")
    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    @Column(name = "NICKNAME")
    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }
}
