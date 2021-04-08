package com.example.jpa.service;

import com.example.jpa.service.dto.CategoryTo;
import com.example.jpa.service.dto.SimpleCategoryTo;

import java.util.List;

public interface CategoryService {
    CategoryTo create(CategoryTo category);

    List<SimpleCategoryTo> getCategoryTree();
}
