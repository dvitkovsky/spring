//package application.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//import static application.helpers.ApplicationProperties.getProperty;
//
//@Configuration
//@EnableTransactionManagement
//public class DataBaseConfiguration {
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(getProperty("db.driver"));
//        dataSource.setUrl(getProperty("db.url"));
//        dataSource.setUsername(getProperty("db.username"));
//        dataSource.setPassword(getProperty("db.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory =
//                new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactory.setDataSource(dataSource);
//
//        entityManagerFactory.setPackagesToScan(getProperty("entitymanager.packagesToScan"));
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//        Properties additionalProperties = new Properties();
//        additionalProperties.put("hibernate.dialect", getProperty("hibernate.dialect"));
//        additionalProperties.put("hibernate.show_sql", getProperty("hibernate.show_sql"));
//        additionalProperties.put("hibernate.hbm2ddl.auto", getProperty("hibernate.hbm2ddl.auto"));
//        entityManagerFactory.setJpaProperties(additionalProperties);
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
//}
