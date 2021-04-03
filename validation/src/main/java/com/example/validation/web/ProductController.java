package com.example.validation.web;

import com.example.validation.service.ProductService;
import com.example.validation.service.dto.ProductCreateTo;
import com.example.validation.service.dto.ProductTo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductTo createProduct(@Valid @RequestBody ProductCreateTo to) {
        return service.createProduct(to);
    }

}
