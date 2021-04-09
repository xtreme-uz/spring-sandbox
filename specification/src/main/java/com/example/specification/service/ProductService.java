package com.example.specification.service;

import com.example.specification.criteria.ProductCriteria;
import com.example.specification.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAll(ProductCriteria criteria, Pageable pageable);

    Product createProduct(Product product);
}
