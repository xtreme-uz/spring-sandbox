package com.example.validation.service.dto;

import com.example.validation.validator.ProductRegion;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class ProductCreateTo {

    @ProductRegion
    private String regionKey;

    @Length(min = 5, max = 255)
    private String name;

    private BigDecimal price;

    @Positive
    private Long inStock;

}
