package uz.xtreme.mongodb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: Rustambekov Avazbek
 * Date: 06/07/2020
 * Time: 16:15
 */

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

}
