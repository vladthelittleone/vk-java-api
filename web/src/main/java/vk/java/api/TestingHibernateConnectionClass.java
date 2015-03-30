package vk.java.api;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vk.java.api.persistence.dao.SequenceDao;

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
    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        SequenceDao dao = (SequenceDao) context.getBean("SequenceDao");

//        Person data = new Person("Sam", "Daniels")
//                .setBirthday("22.22.22")
//                .setNickName("Blind")
//                .setPhoto("http://google.com/photo/?sda#@wd2@#$$5")
//                .setSex(1L)
//                .setPersonId(1L);
//
//        dao.add(data);

        System.out.println (dao.getNexValue());
    }

}
