package com.soap.app.service;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.soap.app.dao.CustomerDAO;
import com.soap.app.model.Customer;

@WebService
public class CustomerServiceImp implements ICustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	@WebMethod
	public void createCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@WebMethod
	public Customer getCustomer(Long id) {
		return customerDAO.getCustomer(id);
	}

	@WebMethod
	public Customer[] getAllCustomer() {
		List<Customer> customers = customerDAO.getAllCustomers();
		Customer[] arrayCustomer = new Customer[customers.size()];
		arrayCustomer = customers.toArray(arrayCustomer); // fill the array
		return arrayCustomer;
	}

	@WebMethod
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@WebMethod
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}
}
