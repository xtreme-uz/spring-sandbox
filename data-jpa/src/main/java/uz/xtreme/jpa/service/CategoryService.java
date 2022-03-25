package uz.xtreme.jpa.service;

import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.domain.Category;
import uz.xtreme.jpa.service.dto.CategoryTo;

import java.util.List;

public interface CategoryService {
    Category create(CategoryTo category);

    @Transactional
    Category update(CategoryTo category);

    Category findById(Long id);

    List<Category> getCategoryTree();
}
