package com.shopping.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.productservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
