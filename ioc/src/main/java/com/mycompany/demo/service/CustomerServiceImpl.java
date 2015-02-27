package com.mycompany.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Service;

import com.mycompany.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private DataSource dataSource1;
	
	@PostConstruct
	public void analyse() {
		System.out.println(ToStringBuilder.reflectionToString(dataSource1));
	}

	@Override
	public void saveCustomer(Customer customer) {
		
	}

	@Override
	public List<Customer> findAllCustomers() {
		return null;
	}

	@Override
	public void deleteCustomerById(Integer id) {
		
	}

	@Override
	public Customer findById(Integer id) {
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		
	}

}
