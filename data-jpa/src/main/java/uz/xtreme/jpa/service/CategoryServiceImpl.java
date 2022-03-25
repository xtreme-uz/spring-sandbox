package uz.xtreme.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.xtreme.jpa.domain.Category;
import uz.xtreme.jpa.repository.CategoryRepository;
import uz.xtreme.jpa.service.dto.CategoryTo;
import uz.xtreme.jpa.service.mapper.CategoryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    @Transactional
    public Category create(CategoryTo category) {
        if (category.getParentId() == null) {
            return repository.save(mapper.fromCreateDto(category));
        }
        Category parent = repository.findById(category.getParentId()).orElseThrow();
        Category child = mapper.fromCreateDto(category);
        parent.addSubCategory(child);

        return repository.save(child);
    }

    @Override
    @Transactional
    public Category update(CategoryTo dto) {
        if (dto.getParentId() == null)
            return repository.save(mapper.fromDto(dto));

        Category newParent = repository.findById(dto.getParentId()).orElseThrow();
        Category category  = repository.findById(dto.getId()).orElseThrow();

        category.changeParentCategory(newParent);
        return repository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }

    @Override
    public List<Category> getCategoryTree() {
        return repository.findAllParentCategories();
    }

}
