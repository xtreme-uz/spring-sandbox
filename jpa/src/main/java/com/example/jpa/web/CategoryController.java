package com.example.jpa.web;

import com.example.jpa.service.CategoryService;
import com.example.jpa.service.dto.CategoryTo;
import com.example.jpa.service.dto.SimpleCategoryTo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public CategoryTo create(@RequestBody CategoryTo category) {
        return service.create(category);
    }

    @GetMapping
    public List<SimpleCategoryTo> getCategoryTree() {
        return service.getCategoryTree();
    }

}
