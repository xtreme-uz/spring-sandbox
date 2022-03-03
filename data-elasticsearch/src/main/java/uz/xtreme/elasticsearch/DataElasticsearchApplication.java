package uz.xtreme.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DataElasticsearchApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataElasticsearchApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Product product = new Product(
                1L,
                "iPhone",
                1,
                new Product.Description(
                        "desc ru",
                        "desc lat",
                        "desc kir"),
                "UZS",
                100.0,
                200.0,
                true,
                true,
                10,
                10,
                "ACTIVE",
                "NEW",
                List.of(new Product.Image(
                        true,
                        new Product.Image.ImageData(
                                "original",
                                "large",
                                "medium",
                                "small"))),
                List.of(new Product.PriceOption(
                        1,
                        3,
                        80.0))
        );
        productRepository.save(product);

        productRepository.deleteByIdIn(Set.of(1L));
    }
}
