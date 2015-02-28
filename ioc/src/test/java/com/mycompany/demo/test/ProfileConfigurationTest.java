package com.mycompany.demo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.demo.entity.Customer;
import com.mycompany.demo.profile.ProfileConfiguration;
import com.mycompany.demo.service.CustomerService;

public class ProfileConfigurationTest {
	
	private AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("development");
		context.register(ProfileConfiguration.class);
		context.refresh();
		assertNotNull(context);

	}

	@Test
	public void test() {
		CustomerService customerService = (CustomerService)context.getBean("customerService");
		Customer customer1 = new Customer();
		customer1.setNombre("Mariane Veloso");
		customerService.saveCustomer(customer1);
		assertNotNull(customerService);
	}

}   
