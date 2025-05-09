 package com.te.orderservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.feignclient.dto.OrderDTO;
import com.te.feignclient.response.SuccessResponse;
import com.te.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/order")
@RestController
public class OrderController {
	
	private final OrderService orderService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path="/")
	public SuccessResponse<String> saveOrder(@RequestBody OrderDTO orderDTO){
		return SuccessResponse.<String>builder()
				.message("order saved")
				.data(orderService.saveOrder(orderDTO))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/{orderId}")
	public SuccessResponse<OrderDTO> getOrder(@PathVariable String orderId){
		return SuccessResponse.<OrderDTO>builder()
				.message("get Order by Id")
				.data(orderService.getOrder(orderId))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/")
	public SuccessResponse<List<OrderDTO>> getOrders(){
		return SuccessResponse.<List<OrderDTO>>builder()
				.message("get all Orders")
				.data(orderService.getOrders())
				.build();
	}
}
