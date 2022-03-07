package uz.xtreme.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import uz.xtreme.elasticsearch.document.Product;

/**
 * Product index repository.
 */
public interface ProductRepository extends ElasticsearchRepository<Product, Long>, ProductSearchRepository {
}

