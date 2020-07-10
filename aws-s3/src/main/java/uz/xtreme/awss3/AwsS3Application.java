package uz.xtreme.awss3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.xtreme.awss3.property.AmazonS3Property;
import uz.xtreme.awss3.property.ProxyProperty;

@EnableConfigurationProperties({
		AmazonS3Property.class,
		ProxyProperty.class
})
@SpringBootApplication
public class AwsS3Application {

	public static void main(String[] args) {
		SpringApplication.run(AwsS3Application.class, args);
	}

}
