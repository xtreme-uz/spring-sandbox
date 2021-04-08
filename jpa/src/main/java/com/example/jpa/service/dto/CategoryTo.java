package com.example.jpa.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTo {

    private Long id;

    private String name;

    private Long parentId;

}
