package uz.xtreme.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Set;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    long deleteByIdIn(Set<Long> ids);

}

