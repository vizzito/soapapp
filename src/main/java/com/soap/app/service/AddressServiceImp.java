package com.soap.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.app.dao.AddressDAO;
import com.soap.app.model.AddressModel;

@Service
public class AddressServiceImp implements IAddressService{
	@Autowired
	private AddressDAO addressDAO;
	
	public void createAddress(AddressModel address) {
		addressDAO.addAddress(address);
	}

	public AddressModel getAddress(Long id) {
		return addressDAO.getAddress(id);
	}

	public List<AddressModel> getAllAddress() {
		List<AddressModel> addresss = addressDAO.getAllAddresss();
		return addresss;
	}

	public void updateAddress(AddressModel address) {
		addressDAO.updateAddress(address);
	}

	public void deleteAddress(Long id) {
		addressDAO.deleteAddress(id);
	}
}
