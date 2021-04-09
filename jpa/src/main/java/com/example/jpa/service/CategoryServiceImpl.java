package com.example.jpa.service;

import com.example.jpa.domain.Category;
import com.example.jpa.repository.CategoryRepository;
import com.example.jpa.service.dto.CategoryTo;
import com.example.jpa.service.dto.SimpleCategoryTo;
import com.example.jpa.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    @Transactional
    public CategoryTo create(CategoryTo category) {
        if (category.getParentId() == null) {
            return mapper.toDto(repository.save(mapper.fromCreateDto(category)));
        }
        Category parent = repository.findById(category.getParentId()).orElseThrow();
        Category child = mapper.fromCreateDto(category);
        parent.addSubCategory(child);

        return mapper.toDto(repository.save(child));
    }

    @Override
    @Transactional
    public CategoryTo update(CategoryTo dto) {
        if (dto.getParentId() == null)
            return mapper.toDto(repository.save(mapper.fromDto(dto)));

        Category newParent = repository.findById(dto.getParentId()).orElseThrow();
        Category category  = repository.findById(dto.getId()).orElseThrow();

        category.moveCategory(newParent);
        return mapper.toDto(repository.save(category));
    }

    @Override
    public List<SimpleCategoryTo> getCategoryTree() {
        return mapper.toSimpleCategory(repository.findAllByParentIsNull());
    }

}
