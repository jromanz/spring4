package com.mycompany.demo.dao;

import java.util.List;

import com.mycompany.demo.entity.Customer;

public interface CustomerDao {
	void saveCustomer(Customer customer);
	List<Customer> findAllCustomers();
	void deleteCustomerById(Integer id);
	Customer findById(Integer id);
	void updateCustomer(Customer customer);
}
