package uz.xtreme.s3bucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.xtreme.s3bucket.property.AmazonS3Property;
import uz.xtreme.s3bucket.property.ProxyProperty;

@EnableConfigurationProperties({
        AmazonS3Property.class,
        ProxyProperty.class
})
@SpringBootApplication
public class S3bucketApplication {

    public static void main(String[] args) {
        SpringApplication.run(S3bucketApplication.class, args);
    }

}
