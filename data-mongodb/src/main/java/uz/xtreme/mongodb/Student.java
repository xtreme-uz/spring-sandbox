package uz.xtreme.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
}
