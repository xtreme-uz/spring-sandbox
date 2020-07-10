package uz.xtreme.awss3.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.xtreme.awss3.property.AmazonS3Property;
import uz.xtreme.awss3.property.ProxyProperty;

/**
 * Author: Rustambekov Avazbek
 * Date: 07/07/2020
 * Time: 16:19
 */

@Configuration
public class AmazonConfig {

    private final AmazonS3Property property;
    private final ProxyProperty proxyProperty;

    public AmazonConfig(AmazonS3Property property, ProxyProperty proxyProperty) {
        this.property = property;
        this.proxyProperty = proxyProperty;
    }

    @Bean
    public AmazonS3 amazonS3() {
        ClientConfiguration configuration = new ClientConfiguration();
        configuration.setProtocol(Protocol.HTTP);
        configuration.setProxyHost(proxyProperty.getHost());
        configuration.setProxyPort(proxyProperty.getPort());

        BasicAWSCredentials credentials = new BasicAWSCredentials(property.getAccessKey(), property.getSecretKey());
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTH_1)
//                .withClientConfiguration(configuration)
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }
}
