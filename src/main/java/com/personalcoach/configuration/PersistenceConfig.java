package com.personalcoach.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.personalcoach.repository")
public class PersistenceConfig {

    private static final String PROP_DB_DRIVER = "db.driver";
    private static final String PROP_DB_URL = "db.url";
    private static final String PROP_DB_USERNAME = "db.username";
    private static final String PROP_DB_PASSWORD = "db.password";
    private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String ENTITY_PACKAGE_TO_SCAN = "com.personalcoach.model";
    private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROP_DB_MULTILINE_EXTRACTOR = "hibernate.hbm2ddl.import_files_sql_extractor";

    @Autowired
    Environment environment;

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(environment.getProperty(PROP_DB_DRIVER));
        ds.setUrl(environment.getProperty(PROP_DB_URL));
        ds.setUsername(environment.getProperty(PROP_DB_USERNAME));
        ds.setPassword(environment.getProperty(PROP_DB_PASSWORD));
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(ENTITY_PACKAGE_TO_SCAN);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());

        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return jpaTransactionManager;
    }


    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(PROP_HIBERNATE_SHOW_SQL, environment.getProperty(PROP_HIBERNATE_SHOW_SQL));
        properties.setProperty(PROP_HIBERNATE_HBM2DDL_AUTO, environment.getProperty(PROP_HIBERNATE_HBM2DDL_AUTO));
        properties.setProperty(PROP_HIBERNATE_DIALECT, environment.getProperty(PROP_HIBERNATE_DIALECT));
        properties.setProperty(PROP_DB_MULTILINE_EXTRACTOR, environment.getProperty(PROP_DB_MULTILINE_EXTRACTOR));
        return properties;
    }
}
