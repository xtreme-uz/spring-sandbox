package com.example.validation.service.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {

    @Positive
    private Long productId;

    @Min(1)
    @Max(100)
    private Integer quantity;

}
