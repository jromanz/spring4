package com.mycompany.demo.profile;

import java.sql.SQLException;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DevelopmentDataSource.class})
@EnableTransactionManagement
public class ProfileConfiguration {

	private String entityPackage = "com.mycompany.demo.entity";
	
	@Inject
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) throws SQLException{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[]{entityPackage});
		sessionFactory.setHibernateProperties(hibernateProperties(environment));
		return sessionFactory;
	}
	
	private Properties hibernateProperties(Environment environment) {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.cache.user_query_cache",environment.getRequiredProperty("hibernate.cache.user_query_cache"));
		properties.put("javax.persistence.validation.mode", environment.getRequiredProperty("javax.persistence.validation.mode"));
		return properties;
	}
	
	@Bean
	   public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
}
