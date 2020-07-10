package uz.xtreme.awss3.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: Rustambekov Avazbek
 * Date: 07/07/2020
 * Time: 11:18
 */

@ConfigurationProperties(prefix = "amazon")
public class AmazonS3Property {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;

    public AmazonS3Property() {
    }

    public AmazonS3Property(String endpoint, String accessKey, String secretKey, String bucketName) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketName = bucketName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
