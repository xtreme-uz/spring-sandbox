package com.example.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(exclude = "subCategories")
@EqualsAndHashCode(exclude = "subCategories")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> subCategories;

    public void addSubCategory(Category subCategory) {
        this.subCategories.add(subCategory);
        subCategory.setParent(this);
    }

    public void removeCategory(Category category) {
        this.subCategories.remove(category);
        category.setParent(null);
    }

}
