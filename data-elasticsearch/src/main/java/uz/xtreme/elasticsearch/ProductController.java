package uz.xtreme.elasticsearch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.xtreme.elasticsearch.document.Product;
import uz.xtreme.elasticsearch.service.ProductService;

/**
 * Rest controller for product.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

  private final ProductService productService;

  /**
   * {@code SEARCH  /_search/products?query=:query} : search for the product corresponding
   * to the query.
   *
   * @param query the query of the product search.
   * @param pageable the pagination information.
   * @return the result of the search.
   */
  @GetMapping("/_search/products")
  public Page<Product> searchProducts(
          @RequestParam String query,
          Pageable pageable
  ) {
    log.info("Searching products with query: {}", query);
    return productService.search(query, pageable);
  }

}
