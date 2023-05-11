package com.shopping.productservice.service;

import java.util.List;

import com.shopping.productservice.dto.ProductRequest;
import com.shopping.productservice.dto.ProductResponse;

public interface ProductService {

	public long addProduct(ProductRequest request);

	public ProductResponse getProductById(long productId);

	public void deleteProductById(long productId);

	public List<ProductResponse> findAllProducts();

}
