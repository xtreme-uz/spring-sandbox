package uz.xtreme.elasticsearch.repository.impl;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.util.StringUtils;
import uz.xtreme.elasticsearch.document.Product;
import uz.xtreme.elasticsearch.repository.ProductSearchRepository;

import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.elasticsearch.search.sort.ScriptSortBuilder.ScriptSortType.NUMBER;

@RequiredArgsConstructor
public class ProductSearchRepositoryImpl implements ProductSearchRepository {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    @Override
    public Page<Product> search(String query, Pageable pageable) {
        QueryBuilder queryBuilder = StringUtils.hasText(query) ? queryStringQuery(query) : matchAllQuery();

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable).build();

        List<Product> hits = elasticsearchTemplate
                .search(searchQuery, Product.class)
                .map(SearchHit::getContent)
                .toList();

        return new PageImpl<>(hits, pageable, hits.size());
    }

    @Override
    public Page<Product> findRandomSeed(String salt, Pageable pageable) {
        Script script = new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG,
                "(doc['_id'].value + params.salt).hashCode()", Map.of("salt", salt));

        ScriptSortBuilder scriptSortBuilder = new ScriptSortBuilder(script, NUMBER);

        var queryBuilder = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withPageable(pageable)
                .withSorts(scriptSortBuilder)
                .build();

        List<Product> hits = elasticsearchTemplate
                .search(queryBuilder, Product.class)
                .map(SearchHit::getContent)
                .toList();

        return new PageImpl<>(hits, pageable, hits.size());
    }

}
