package com.mycompany.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

import com.mycompany.demo.configuration.ApplicationConfiguration;

public class ConfigurationTest {

	@Test
	public void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);
		
		assertNotNull(context);
	}

}
