package com.te.orderservice.exception;

public class OrderIdNotFoundException extends RuntimeException {

	public OrderIdNotFoundException(String message) {
		super(message);
	}
}
