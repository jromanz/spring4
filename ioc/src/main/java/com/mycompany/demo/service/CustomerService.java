package com.mycompany.demo.service;

import java.util.List;

import com.mycompany.demo.entity.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	List<Customer> findAllCustomers();
	void deleteCustomerById(Integer id);
	Customer findById(Integer id);
	void updateCustomer(Customer customer);
}
