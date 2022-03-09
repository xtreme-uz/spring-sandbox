package uz.xtreme.jpa.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.xtreme.jpa.service.CategoryService;
import uz.xtreme.jpa.service.dto.CategoryTo;
import uz.xtreme.jpa.service.dto.SimpleCategoryTo;

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

    @PutMapping
    public CategoryTo update(@RequestBody CategoryTo category) {
        return service.update(category);
    }

    @GetMapping
    public List<SimpleCategoryTo> getCategoryTree() {
        return service.getCategoryTree();
    }

}
