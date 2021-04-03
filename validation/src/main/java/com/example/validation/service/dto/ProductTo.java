package com.example.validation.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductTo {

    private Long id;

    private String regionKey;

    private String name;

    private BigDecimal price;
}
