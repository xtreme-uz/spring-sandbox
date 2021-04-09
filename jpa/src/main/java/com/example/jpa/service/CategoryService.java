package com.example.jpa.service;

import com.example.jpa.service.dto.CategoryTo;
import com.example.jpa.service.dto.SimpleCategoryTo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
    CategoryTo create(CategoryTo category);

    @Transactional
    CategoryTo update(CategoryTo category);

    List<SimpleCategoryTo> getCategoryTree();
}
