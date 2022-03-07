package uz.xtreme.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.xtreme.elasticsearch.document.Product;

public interface ProductSearchRepository {
  Page<Product> search(String query, Pageable pageable);
}
