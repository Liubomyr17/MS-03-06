package mvc.MUSIC_STORE.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"mvc.MUSIC_STORE.dto"})
@EnableTransactionManagement
public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/ms";
    private final static String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL57Dialect";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "12345";

    @Bean("dataSource")
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        // Providing the database connection information
        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

    // sessionFactory bean will be available
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

        builder.addProperties(getHibernateProperties());
        builder.scanPackages("net.mvc.ProjectMVC.dto");

        return builder.buildSessionFactory();
    }

    // All the hibernate properties will be returned in this method
    private Properties getHibernateProperties() {

        Properties properties = new Properties();

        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }


}

