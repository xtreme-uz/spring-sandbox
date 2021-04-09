package com.example.specification.service.impl;

import com.example.specification.criteria.ProductCriteria;
import com.example.specification.domain.Product;
import com.example.specification.domain.Product_;
import com.example.specification.repository.ProductRepository;
import com.example.specification.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends QueryService<Product> implements ProductService {

    private final ProductRepository repository;

    @Override
    public Page<Product> getAll(ProductCriteria criteria, Pageable pageable) {
        return repository.findAll(buildSpecification(criteria), pageable);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    private Specification<Product> buildSpecification(ProductCriteria criteria) {
        Specification<Product> specification = Specification.where(null);

        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Product_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Product_.name));
            }
            if (criteria.getCost() != null) {
                specification =specification.and(buildRangeSpecification(criteria.getCost(), Product_.cost));
            }
            if (criteria.getQuantity() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getQuantity(), Product_.quantity));
            }
        }
        return specification;
    }
}
