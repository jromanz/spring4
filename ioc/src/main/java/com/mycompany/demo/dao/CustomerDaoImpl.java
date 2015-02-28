package com.mycompany.demo.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.demo.entity.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	}

	@Override
	public List<Customer> findAllCustomers() {
		Criteria listCustomer = sessionFactory.getCurrentSession()
				.createCriteria(Customer.class);
		return (List<Customer>) listCustomer.list();
	}

	@Override
	public void deleteCustomerById(Integer id) {
		Query queryDeleteCustomer = sessionFactory.getCurrentSession()
				.createSQLQuery("delete from customer where id = :id");
		queryDeleteCustomer.setInteger("id", id);
		queryDeleteCustomer.executeUpdate();
	}

	@Override
	public Customer findById(Integer id) {
		Criteria customerFound = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		customerFound.add(Restrictions.eq("id", id));
		return (Customer)customerFound.uniqueResult();
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
