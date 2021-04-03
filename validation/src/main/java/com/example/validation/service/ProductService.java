package com.example.validation.service;

import com.example.validation.service.dto.ProductCreateTo;
import com.example.validation.service.dto.ProductTo;

public interface ProductService {
    ProductTo createProduct(ProductCreateTo to);
}
