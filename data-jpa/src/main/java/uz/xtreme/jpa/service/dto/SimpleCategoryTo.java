package uz.xtreme.jpa.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleCategoryTo {
    private Long id;

    private String name;

    private Set<SimpleCategoryTo> subCategories;
}
