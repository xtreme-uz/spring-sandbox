package com.example.specification.criteria.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StringFilter extends Filter<String> {

    private String contains;
    private String doesNotContain;

}
