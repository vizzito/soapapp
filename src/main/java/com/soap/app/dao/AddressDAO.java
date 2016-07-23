package com.soap.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soap.app.model.AddressModel;
import com.soap.app.repository.AddressCRUDRepository;

@Component
public class AddressDAO {
	private static final Logger LOG = LoggerFactory.getLogger(AddressDAO.class);
	@Autowired
	private AddressCRUDRepository repository;
	
	public void addAddress(AddressModel address) {
		repository.save(address);
		LOG.info("Address saved successfully, Address Details=" + address);
	}
	
	public void deleteAddress(Long id) {
		repository.delete(id);
		LOG.info("Address was successfully removed");
	}
	
	public void updateAddress(AddressModel address) {
		AddressModel c = repository.findOne(address.getId());
		c.setCity(address.getCity());
		c.setNumber(address.getNumber());
		c.setStreet(address.getStreet());
		repository.save(c);
		LOG.info("Address updated successfully, Address Details=" + address);
	}
	
	public AddressModel getAddress(Long id) {
		return repository.findOne(id);		
	}
	
	public List<AddressModel> getAllAddresss() {
		return repository.findAll();
	}
}
