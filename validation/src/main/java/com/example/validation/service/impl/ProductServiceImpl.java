package com.example.validation.service.impl;

import com.example.validation.repository.ProductRepository;
import com.example.validation.service.ProductService;
import com.example.validation.service.dto.ProductCreateTo;
import com.example.validation.service.dto.ProductTo;
import com.example.validation.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductTo createProduct(ProductCreateTo to) {
        return mapper.toDto(repository.save(mapper.fromCreateDto(to)));
    }

}
