package com.soap.app.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.soap.app.model.Customer;
@WebService
public interface ICustomerService {
	@WebMethod
	public void createCustomer(Customer customer);
	@WebMethod
	public Customer getCustomer(Long id);
	@WebMethod
	public Customer[] getAllCustomer(); 
	@WebMethod
	public void updateCustomer(Customer customer); 
	@WebMethod
	public void deleteCustomer(Customer customer); 
}
