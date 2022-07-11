package yjjeong.jpa.springdata.configuration;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

@Configuration
@PropertySource({"classpath:application.yml"})
public class JPAConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean(destroyMethod = "")
    public DataSource dataSourceForJpa() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public Log4jdbcProxyDataSource dataSourceForJpaLog4jdbc() {

        Log4jdbcProxyDataSource proxy = new Log4jdbcProxyDataSource(this.dataSourceForJpa());

        Log4JdbcCustomFormatter formatter = new Log4JdbcCustomFormatter();
        formatter.setLoggingType(LoggingType.MULTI_LINE);
        formatter.setSqlPrefix("SQL:::");

        proxy.setLogFormatter(formatter);

        return proxy;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSourceForJpa());
        entityManagerFactoryBean.setPackagesToScan(new String[]{
                "yjjeong.jpa.springdata.*.entity",
        });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }

    @Value("${jpa.generate-ddl}")
    private String envAutoDdl;
    @Value("${jpa.properties.hibernate.format_sql}")
    private String envFormatSql;
    @Value("${jpa.show-sql}")
    private String envShowSql;
    @Value("${jpa.properties.dialect}")
    private String envDialect;

    public Properties additionalProperties() {

        final Properties properties = new Properties();
        properties.setProperty(Environment.HBM2DDL_AUTO, envAutoDdl);
        properties.setProperty(Environment.FORMAT_SQL, envFormatSql);
        properties.setProperty(Environment.SHOW_SQL, envShowSql);
        properties.setProperty(Environment.DIALECT, envDialect);

        return properties;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManger = entityManagerFactory.createEntityManager();

        return entityManger;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

        return new PersistenceExceptionTranslationPostProcessor();
    }

}
