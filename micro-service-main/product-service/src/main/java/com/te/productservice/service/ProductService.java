package com.te.productservice.service;

import java.util.List;

import com.te.feignclient.dto.ProductDTO;

public interface ProductService {

	String saveProduct(ProductDTO productDTO);

	ProductDTO getProduct(String productId);

	List<ProductDTO> getServices();

	ProductDTO reduceQuantity(String productId, int quantity);

}
