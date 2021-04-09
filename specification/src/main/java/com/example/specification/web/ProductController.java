package com.example.specification.web;

import com.example.specification.domain.Product;
import com.example.specification.criteria.ProductCriteria;
import com.example.specification.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public Page<Product> getAll(ProductCriteria criteria, Pageable pageable){
        return service.getAll(criteria, pageable);
    }

}
