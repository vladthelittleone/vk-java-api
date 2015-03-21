package vk.java.api.persistence.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@org.springframework.context.annotation.Configuration
@PropertySource({"classpath:persistence.properties"})
@ComponentScan({"vk.java.api.persistence"})
public class PersistenceConfig
{
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("vk.java.api.persistence");
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties()
    {
        return new Properties()
        {
            {
                setProperty("hibernate.bytecode.use_reflection_optimizer", env.getProperty("hibernate.bytecode.use_reflection_optimizer"));
                setProperty("hibernate.connection.pool_size", env.getProperty("hibernate.connection.pool_size"));
                setProperty("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
                setProperty("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
                setProperty("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
                setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
                setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
                setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
                // This will drop our existing database and re-create a new one. Existing data will be deleted!
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
                setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                setProperty("hibernate.globally_quoted_identifiers", env.getProperty("hibernate.globally_quoted_identifiers"));
                setProperty("hibernate.connection.driver_class", env.getProperty("jdbc.driver.name"));
            }
        };
    }
}
