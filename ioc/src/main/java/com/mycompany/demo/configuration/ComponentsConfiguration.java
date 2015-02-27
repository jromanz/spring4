package com.mycompany.demo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.mycompany.demo" })
public class ComponentsConfiguration {

}
