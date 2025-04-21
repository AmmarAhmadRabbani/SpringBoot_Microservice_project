package com.te.customerservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.customerservices.service.CustomerService;
import com.te.feignclient.dto.CustomerDTO;
import com.te.feignclient.response.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "/")
	public SuccessResponse<String> saveCustomer(@RequestBody CustomerDTO customerDTO) {
		return SuccessResponse.<String>builder().message("Customer").data(customerService.saveCustomer(customerDTO))
				.build();
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/{customerId}")
	public SuccessResponse<CustomerDTO> getCustomer(@PathVariable String customerId) {
		return SuccessResponse.<CustomerDTO>builder().message("Provided customer by Id")
				.data(customerService.getCustomer(customerId)).build();
	}

	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/")
	public SuccessResponse<List<CustomerDTO>> getCustomers() {
		return SuccessResponse.<List<CustomerDTO>>builder()
				.message("get all the customers")
				.data(customerService.getCustomers())
				.build();

	}
}
