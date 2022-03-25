package uz.xtreme.jpa.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.jpa.domain.Category;
import uz.xtreme.jpa.service.CategoryService;
import uz.xtreme.jpa.service.dto.CategoryTo;
import uz.xtreme.jpa.service.dto.SimpleCategoryTo;
import uz.xtreme.jpa.service.mapper.CategoryMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    @PostMapping
    public CategoryTo create(@RequestBody CategoryTo dto) {
        Category category = service.create(dto);
        return mapper.toDto(category);
    }

    @PutMapping
    public CategoryTo update(@RequestBody CategoryTo dto) {
        var category = service.update(dto);
        return mapper.toDto(category);
    }

    @GetMapping("/{id}")
    public CategoryTo getById(@PathVariable Long id) {
        Category category = service.findById(id);
        return mapper.toDto(category);
    }

    @GetMapping
    public List<SimpleCategoryTo> getCategoryTree() {
        List<Category> categories = service.getCategoryTree();
        return mapper.toSimpleCategory(categories);
    }

}
