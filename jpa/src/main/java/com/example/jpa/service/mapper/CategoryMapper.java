package com.example.jpa.service.mapper;

import com.example.jpa.domain.Category;
import com.example.jpa.service.dto.CategoryTo;
import com.example.jpa.service.dto.SimpleCategoryTo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category fromCreateDto(CategoryTo category);

    @Mapping(target = "parentId", source = "parent.id")
    CategoryTo toDto(Category category);

    List<SimpleCategoryTo> toSimpleCategory(List<Category> categories);
}
