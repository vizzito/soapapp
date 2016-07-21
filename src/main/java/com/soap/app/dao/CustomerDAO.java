package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.soap.app.model.Customer;
import com.soap.app.repository.CustomerCRUDRepository;

@Component
public class CustomerDAO {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDAO.class);
	@Autowired
	private CustomerCRUDRepository repository;
	
	public void addCustomer(Customer customer) {
		repository.save(customer);
		LOG.info("Customer saved successfully, Customer Details=" + customer);
	}
	
	public void deleteCustomer(Customer customer) {
		repository.delete(customer);
		LOG.info("Customer was successfully removed, Customer Details=" + customer);
	}
	
	public void updateCustomer(Customer customer) {
		Customer c = repository.findOne(customer.getId());
		c.setCountry(customer.getCountry());
		c.setName(customer.getName());
		repository.save(c);
		LOG.info("Customer updated successfully, Customer Details=" + customer);
	}
	
	public Customer getCustomer(Long id) {
		return repository.getOne(id);		
	}
	
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
}
