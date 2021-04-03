package com.example.validation.service.mapper;

import com.example.validation.domain.Product;
import com.example.validation.service.dto.ProductCreateTo;
import com.example.validation.service.dto.ProductTo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product fromCreateDto(ProductCreateTo to);

    ProductTo toDto(Product product);

}
