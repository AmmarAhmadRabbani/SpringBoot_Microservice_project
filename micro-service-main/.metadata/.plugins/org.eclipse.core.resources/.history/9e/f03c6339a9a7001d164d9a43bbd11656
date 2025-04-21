package com.te.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.te.feignclient.dto.ProductDTO;
import com.te.feignclient.response.SuccessResponse;
import com.te.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/product")
@RestController
public class ProductController {

	private final ProductService productService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/")
	public SuccessResponse<String> saveProduct(@RequestBody ProductDTO productDTO) {
		return SuccessResponse.<String>builder()
				.message("product saved")
				.data(productService.saveProduct(productDTO))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/{productId}")
	public SuccessResponse<ProductDTO> getProduct(@PathVariable String productId ){
		return SuccessResponse.<ProductDTO>builder()
				.message("get product Id")
				.data(productService.getProduct(productId))
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.OK )
	@GetMapping("/")
	public SuccessResponse<List<ProductDTO>> getProducts(){
		return SuccessResponse.<List<ProductDTO>>builder()
				.message("get all the name")
				.data(productService.getServices())
				.build();
	}
	
	@ResponseStatus(value = HttpStatus.CREATED )
	@PutMapping("/{productId}")
	public SuccessResponse<ProductDTO> reduceQuantity(@PathVariable String productId,@RequestParam int quantity){
		return SuccessResponse.<ProductDTO>builder()
				.message("Product updated")
				.data(productService.reduceQuantity(productId,quantity))
				.build();
	}
}
