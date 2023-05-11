package com.shopping.productservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.productservice.dto.ProductRequest;
import com.shopping.productservice.dto.ProductResponse;
import com.shopping.productservice.service.ProductService;

@RestController
public class ProductController {

	public static final Logger log = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<ProductResponse> findAllProducts() {
		List<ProductResponse> produits = productService.findAllProducts();

		return produits;
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {

		log.info("ProductController | getProductById is called");

		log.info("ProductController | getProductById | productId : " + productId);

		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

		log.info("ProductController | addProduct is called");

		log.info("ProductController | addProduct | productRequest : " + productRequest.toString());

		long productId = productService.addProduct(productRequest);
		return new ResponseEntity<>(productId, HttpStatus.CREATED);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable("id") long productId) {
		productService.deleteProductById(productId);
	}
}