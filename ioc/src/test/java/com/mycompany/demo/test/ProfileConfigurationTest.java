package com.mycompany.demo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.demo.configuration.ApplicationConfiguration;
import com.mycompany.demo.profile.ProfileConfiguration;

public class ProfileConfigurationTest {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);
		context.getEnvironment().setActiveProfiles("development");
		context.register(ProfileConfiguration.class);
		context.refresh();
		assertNotNull(context);
	}

}
