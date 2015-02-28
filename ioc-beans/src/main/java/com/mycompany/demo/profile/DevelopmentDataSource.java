package com.mycompany.demo.profile;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("development")
public class DevelopmentDataSource {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() throws SQLException {
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(environment.getProperty("hibernate.connection.url"));
		dataSource.setUsername(environment.getProperty("hibernate.connection.username"));
		dataSource.setPassword(environment.getProperty("hibernate.connection.password"));
		return dataSource;
	}	
	
}
