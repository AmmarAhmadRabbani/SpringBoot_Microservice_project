package com.te.orderservice.service;

import java.util.List;

import com.te.feignclient.dto.OrderDTO;

public interface OrderService {

	String saveOrder(OrderDTO orderDTO);

	OrderDTO getOrder(String orderId);

	List<OrderDTO> getOrders();

}
