package com.shopping.productservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.productservice.dto.ProductRequest;

@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	public void test() {
		ProductRequest request = new ProductRequest();
		request.setName("PROD1");
		request.setPrice(300);
		request.setQuantity(23);

		Long id = productService.addProduct(request);
		assertEquals(1, id);

		String productName = productService.getProductById(1).getProductName();
		assertEquals("PROD1", productName);
	}
}
