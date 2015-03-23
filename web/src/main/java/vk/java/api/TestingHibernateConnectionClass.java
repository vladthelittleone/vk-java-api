package vk.java.api;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vk.java.api.persistence.dao.LikesDao;
import vk.java.api.persistence.dao.PersonDao;
import vk.java.api.persistence.domain.Likes;
import vk.java.api.persistence.domain.Person;

/**
 * package: vk.java.api
 * date: 21.03.15
 * <p/>
 * Для запуска нужно перетащить applicationContext.xml и
 * hibernate-context.xml в resources.
 *
 * @author Skurishin Vladislav
 */
public class TestingHibernateConnectionClass
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"src/main/webapp/WEB-INF/applicationContext.xml"}, true);
        PersonDao dao = (PersonDao) context.getBean("PersonDao");

        Person data = new Person("Sam", "Daniels")
                .setBirthday("22.22.22")
                .setNickName("Blind")
                .setPhoto("http://google.com/photo/?sda#@wd2@#$$5")
                .setSex(1L);

        Long id = dao.add(data);

        System.out.println(dao.get(id).getNickName());

        LikesDao likesDao = (LikesDao) context.getBean("LikesDao");

        Likes data1 = new Likes();
        data1.setAmount(100L);
        data1.setPersonId(1L);

        likesDao.add(data1);

        Likes data2 ;
        data2 = likesDao.get(1L);
        System.out.println("Amount " + data2.getAmount() + "Id " + data2.getPersonId());
        likesDao.change(1L);
        data2 = likesDao.get(1L);
        System.out.println("Amount " + data2.getAmount() + "Id " + data2.getPersonId());


    }

}
