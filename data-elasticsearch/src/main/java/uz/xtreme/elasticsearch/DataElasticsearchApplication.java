package uz.xtreme.elasticsearch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import uz.xtreme.elasticsearch.document.Product;
import uz.xtreme.elasticsearch.repository.ProductRepository;

/**
 * A sample application that demonstrates how to use Elasticsearch.
 */
@SpringBootApplication
public class DataElasticsearchApplication implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Value("classpath:data/products.json")
  private Resource products;

  public static void main(String[] args) {
    SpringApplication.run(DataElasticsearchApplication.class, args);
  }

  @Override
  public void run(String... args) throws IOException {
    List<Product> productsList = objectMapper
            .readValue(products.getInputStream(), new TypeReference<>() {});
    productRepository.saveAll(productsList);
  }
}
