package uz.xtreme.elasticsearch.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import uz.xtreme.elasticsearch.document.Product;
import uz.xtreme.elasticsearch.repository.ProductSearchRepository;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@RequiredArgsConstructor
public class ProductSearchRepositoryImpl implements ProductSearchRepository {

  private final ElasticsearchRestTemplate elasticsearchTemplate;

  @Override
  public Page<Product> search(String query, Pageable pageable) {
    NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
    nativeSearchQuery.setPageable(pageable);
    List<Product> hits = elasticsearchTemplate
            .search(nativeSearchQuery, Product.class)
            .map(SearchHit::getContent)
            .toList();

    return new PageImpl<>(hits, pageable, hits.size());
  }

}
