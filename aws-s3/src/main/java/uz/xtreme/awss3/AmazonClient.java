package uz.xtreme.awss3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.xtreme.awss3.property.AmazonS3Property;

import java.io.IOException;

/**
 * Author: Rustambekov Avazbek
 * Date: 07/07/2020
 * Time: 11:06
 */

@Service
public class AmazonClient {

    private final AmazonS3 amazonS3;
    private final AmazonS3Property property;

    public AmazonClient(AmazonS3 amazonS3, AmazonS3Property property) {
        this.amazonS3 = amazonS3;
        this.property = property;
    }

    public String uploadFile(MultipartFile multipartFile) {
        String fileUrl ="";
        try {
            String fileName = (System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename()).replace(" ", "_");
            fileUrl = property.getEndpoint() + "/" + property.getBucketName() + "/" + fileName;

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(multipartFile.getContentType());
            objectMetadata.setContentLength(multipartFile.getSize());

            amazonS3.putObject(property.getBucketName(), fileName, multipartFile.getInputStream(), objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    public String deleteFile(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        amazonS3.deleteObject(new DeleteObjectRequest(property.getBucketName() + "/", fileName));
        return fileName;
    }


}
