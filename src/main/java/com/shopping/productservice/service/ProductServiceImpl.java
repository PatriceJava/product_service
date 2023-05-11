package com.shopping.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.productservice.dto.ProductRequest;
import com.shopping.productservice.dto.ProductResponse;
import com.shopping.productservice.entities.Product;
import com.shopping.productservice.exception.ProductServiceException;
import com.shopping.productservice.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	public static final Logger log = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest request) {
		log.info("ProductServiceImpl {}", request);

		Product product = new Product();
		product.setProductName(request.getName());
		product.setQuantity(request.getQuantity());
		product.setPrice(request.getPrice());

		product = productRepository.save(product);

		log.info("ProductServiceImpl | addProduct | Product Created");
		log.info("ProductServiceImpl | addProduct | Product Id : " + product.getId());
		return product.getId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("ProductServiceImpl | getProductById is called");
		log.info("ProductServiceImpl | getProductById | Get the product for productId: {}", productId);

		Product product = productRepository.findById(productId).get();
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);

		log.info("ProductServiceImpl | getProductById | productResponse :" + productResponse.toString());

		return productResponse;
	}

	@Override
	public void deleteProductById(long productId) {
		log.info("Product id: {}", productId);

		if (!productRepository.existsById(productId)) {
			log.info("Im in this loop {}", !productRepository.existsById(productId));
			throw new ProductServiceException("Product with given with Id: " + productId + " not found:",
					"PRODUCT_NOT_FOUND");
		}
		log.info("Deleting Product with id: {}", productId);
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductResponse> findAllProducts() {
		log.info("ProductServiceImpl | findAllProducts is called");

		List<Product> productList = productRepository.findAll();
		List<ProductResponse> productResponseList = new ArrayList<>();
		for (Product source : productList) {
			ProductResponse target = new ProductResponse();
			BeanUtils.copyProperties(source, target);
			productResponseList.add(target);
		}
		log.info("ProductServiceImpl | findAllProducts :" + productResponseList.toString());

		return productResponseList;
	}
}
