package com.te.customerservices.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.customerservices.entity.Customer;
import com.te.customerservices.exception.CustomerNotFoundException;
import com.te.customerservices.repository.CustomerRepository;
import com.te.feignclient.dto.CustomerDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

	public final CustomerRepository customerRepository;

	@Override
	public String saveCustomer(CustomerDTO customerDTO) {
		return customerRepository.save(Customer.builder().customerId(UUID.randomUUID().toString())
				.customerName(customerDTO.getCustomerName()).customerEmail(customerDTO.getCustomerEmail()).build())
				.getCustomerId();
	}

	@Override
	public CustomerDTO getCustomer(String customerId) {
		return customerRepository.findById(customerId).map(customer->{
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO );
			return customerDTO;
		}).orElseThrow(() -> new CustomerNotFoundException("Customer Id not found"));
	}

	@Override
	public List<CustomerDTO> getCustomers() {
		return customerRepository.findAll().stream().map(customer->{
			CustomerDTO customerDTO = new CustomerDTO();
			BeanUtils.copyProperties(customer, customerDTO);
			return customerDTO;
		}).collect(Collectors.toList());
	}

}
