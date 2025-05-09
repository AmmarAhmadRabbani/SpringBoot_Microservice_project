package com.te.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.te.feignclient.dto.OrderDTO;
import com.te.feignclient.dto.ProductDTO;
import com.te.feignclient.response.SuccessResponse;
import com.te.orderservice.entity.Order;
import com.te.orderservice.exception.OrderIdNotFoundException;
import com.te.orderservice.repository.OrderRepository;
import com.te.orderservice.service.external.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;
	private final ProductService productService;

	@Override
	public String saveOrder(OrderDTO orderDTO) {
		// by using eureka method-----------------------------------
		// SuccessResponse forObject =
		// restTemplate.getForObject("http://PRODUCT-SERVICE/product/" +
		// orderDTO.getProductId(), SuccessResponse.class);
		// System.out.println(forObject.getData());

		// by using open-feign method--------------------------------
		SuccessResponse<ProductDTO> successResponse = productService.getProduct(orderDTO.getProductId());
//		System.out.println(successResponse.getData());

		SuccessResponse<ProductDTO> reduceQuantity = productService.reduceQuantity(orderDTO.getProductId(),
				orderDTO.getOrderQuantity());
//		System.out.println(reduceQuantity.getData());
		return orderRepository
				.save(Order.builder().orderQuantity(orderDTO.getOrderQuantity()).orderAmount(orderDTO.getOrderAmount())
						.customerId(orderDTO.getCustomerId()).productId(orderDTO.getProductId()).build())
				.getOrderId();
	}

	@Override
	public OrderDTO getOrder(String orderId) {
		return orderRepository.findById(orderId).map(order -> {
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(order, orderDTO);
			return orderDTO;
		}).orElseThrow(() -> new OrderIdNotFoundException("Order Id not found"));
	}

	@Override
	public List<OrderDTO> getOrders() {
		return orderRepository.findAll().stream().map(order -> {
			OrderDTO orderDTO = new OrderDTO();
			BeanUtils.copyProperties(order, orderDTO);
			return orderDTO;
		}).collect(Collectors.toList());
	}

}
