package com.te.productservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.feignclient.dto.ProductDTO;
import com.te.productservice.entity.Product;
import com.te.productservice.exception.ProductNotFoundException;
import com.te.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public String saveProduct(ProductDTO productDTO) {
		return productRepository.save(Product.builder().productId(UUID.randomUUID().toString())
				.productName(productDTO.getProductName()).productPrice(productDTO.getProductPrice())
				.productQuantity(productDTO.getProductQuantity()).build()).getProductId();
	}

	@Override
	public ProductDTO getProduct(String productId) {
		return productRepository.findById(productId).map(product->{
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
		}).orElseThrow(()-> new ProductNotFoundException("Product Id not found"));
	}

	@Override
	public List<ProductDTO> getServices() {
		return productRepository.findAll().stream().map(product->{
			ProductDTO productDTO  = new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
		}).collect(Collectors.toList());
	}

	@Override
	public ProductDTO reduceQuantity(String productId, int quantity) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException(productId+"product Id not found"));
		if(product.getProductQuantity() >= quantity) {
			product.setProductQuantity(product.getProductQuantity() - quantity);
			Product productSave = productRepository.save(product);
			ProductDTO productDTO  = new ProductDTO();
			BeanUtils.copyProperties(productSave, productDTO);
			return productDTO;
		}
		return null;
	}

}
