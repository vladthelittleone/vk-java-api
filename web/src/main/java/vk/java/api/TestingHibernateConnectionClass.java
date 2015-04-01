package vk.java.api;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import vk.java.api.persistence.dao.LikesDao;
import vk.java.api.persistence.dao.PersonDao;
import vk.java.api.persistence.dao.SequenceDao;
import vk.java.api.persistence.domain.Likes;
import vk.java.api.persistence.domain.Person;
import vk.java.api.persistence.domain.Sequence;
import vk.java.api.persistence.sharding.ShardingContextHolder;

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

        LikesDao likesDao = (LikesDao) context.getBean("LikesDao");
        PersonDao personDao = (PersonDao) context.getBean("PersonDao");
        SequenceDao sequenceDao = (SequenceDao) context.getBean("SequenceDao");

        ShardingContextHolder.set("SEQUENCE", 0L);
        sequenceDao.add(new Sequence().setName("PERSON").setSequence(0L));
        sequenceDao.getNextValue("PERSON");

        Person person = new Person("Sam", "Daniels")
                .setBirthday("22.22.22")
                .setNickName("Blind")
                .setPhoto("http://google.com/photo/?sda#@wd2@#$$5")
                .setSex(1L);

        ShardingContextHolder.set("PERSON", 0L);
        Long id = personDao.add(person);

        Likes likes = new Likes()
                .setAmount(1L)
                .setPersonId(id);

        ShardingContextHolder.set("LIKES", 0L);
        likesDao.add(likes);
        likesDao.increaseLikesAmount(id);
    }

}
