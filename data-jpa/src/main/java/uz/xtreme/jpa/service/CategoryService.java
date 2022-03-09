package uz.xtreme.jpa.service;

import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.service.dto.CategoryTo;
import uz.xtreme.jpa.service.dto.SimpleCategoryTo;

import java.util.List;

public interface CategoryService {
    CategoryTo create(CategoryTo category);

    @Transactional
    CategoryTo update(CategoryTo category);

    List<SimpleCategoryTo> getCategoryTree();
}
