package com.mycompany.demo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.demo.entity.Customer;

@Component
public interface CustomerDao {
	void saveCustomer(Customer customer);
	List<Customer> findAllCustomers();
	void deleteCustomerById(Integer id);
	Customer findById(Integer id);
	void updateCustomer(Customer customer);
}
