package uz.xtreme.elasticsearch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.xtreme.elasticsearch.document.Product;
import uz.xtreme.elasticsearch.repository.ProductRepository;
import uz.xtreme.elasticsearch.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  @Override
  public Page<Product> search(String query, Pageable pageable) {
    return repository.search(query, pageable);
  }
}
