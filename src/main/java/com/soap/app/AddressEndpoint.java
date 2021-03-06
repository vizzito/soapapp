package com.soap.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.app.model.AddressModel;
//import com.soap.app.populator.AddressPopulator;
//import com.soap.app.service.AddressServiceImp;
import com.soap.app.populator.AddressPopulator;
import com.soap.app.service.AddressServiceImp;

import soap.com.app.producing_web_service.AddAddressRequest;
import soap.com.app.producing_web_service.AddAddressResponse;
import soap.com.app.producing_web_service.Address;
import soap.com.app.producing_web_service.GetAddressRequest;
import soap.com.app.producing_web_service.GetAddressResponse;
import soap.com.app.producing_web_service.GetAllAddressResponse;
import soap.com.app.producing_web_service.RemoveAddressRequest;
import soap.com.app.producing_web_service.RemoveAddressResponse;
import soap.com.app.producing_web_service.UpdateAddressRequest;
import soap.com.app.producing_web_service.UpdateAddressResponse;

@Endpoint
public class AddressEndpoint {
	private static final String NAMESPACE_URI = "http://com.soap/app/producing-web-service";
	
	@Autowired
	private AddressServiceImp addressService;
	
	@Autowired
	private AddressPopulator addressPopulator;

	public AddressEndpoint() {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAddressRequest")
	@ResponsePayload
	public GetAddressResponse getAddress(@RequestPayload GetAddressRequest request) {
		GetAddressResponse response = new GetAddressResponse();
		AddressModel cm = addressService.getAddress(request.getId());
		Address c = addressPopulator.toExternalModel(cm);
		response.setAddress(c);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAddressRequest")
	@ResponsePayload
	public AddAddressResponse addAddress(@RequestPayload AddAddressRequest request) {
		AddAddressResponse response = new AddAddressResponse();
		AddressModel c = addressPopulator.toModel(request.getAddress());
		addressService.createAddress(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAddressRequest")
	@ResponsePayload
	public UpdateAddressResponse updateAddress(@RequestPayload UpdateAddressRequest request) {
		UpdateAddressResponse response = new UpdateAddressResponse();
		AddressModel c = addressPopulator.toModel(request.getAddress());
		addressService.updateAddress(c);
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeAddressRequest")
	@ResponsePayload
	public RemoveAddressResponse removeAddress(@RequestPayload RemoveAddressRequest request) {
		RemoveAddressResponse response = new RemoveAddressResponse();
		addressService.deleteAddress(request.getId());
		response.setResponse("Success!!");
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAddressRequest")
	@ResponsePayload
	public GetAllAddressResponse getAllAddress() {
		GetAllAddressResponse response = new GetAllAddressResponse();
		List<AddressModel> addresss = addressService.getAllAddress();
		response.getResponse().addAll(addressPopulator.toExternalModel(addresss));
		return response;
	}
}
