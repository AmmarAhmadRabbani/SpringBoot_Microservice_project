package com.te.orderservice.exception.handle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.te.feignclient.response.ErrorResponse;
import com.te.orderservice.exception.OrderIdNotFoundException;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({
		OrderIdNotFoundException.class
	})
	public ErrorResponse handler(RuntimeException exception) {
		return ErrorResponse.builder()
				.error(exception.getMessage())
				.build();
	}
}
