package com.te.customerservices.service;

import java.util.List;

import com.te.feignclient.dto.CustomerDTO;

public interface CustomerService {

	String saveCustomer(CustomerDTO customerDTO);

	CustomerDTO getCustomer(String customerId);

	List<CustomerDTO> getCustomers();

}
