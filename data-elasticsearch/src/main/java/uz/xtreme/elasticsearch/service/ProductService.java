package uz.xtreme.elasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.xtreme.elasticsearch.document.Product;

public interface ProductService {
  Page<Product> search(String query, Pageable pageable);
}
