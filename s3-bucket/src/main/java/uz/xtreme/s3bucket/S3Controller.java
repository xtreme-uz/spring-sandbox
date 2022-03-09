package uz.xtreme.s3bucket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Rustambekov Avazbek
 * Date: 07/07/2020
 * Time: 11:04
 */

@RestController
@RequestMapping("/v1/storage")
public class S3Controller {

    private final AmazonClient amazonClient;

    public S3Controller(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return amazonClient.uploadFile(file);
    }

    @PostMapping("/delete")
    public String deleteFile(@RequestPart(value = "url") String url) {
        return amazonClient.deleteFile(url);
    }
}
