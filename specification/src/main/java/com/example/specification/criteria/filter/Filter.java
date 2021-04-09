package com.example.specification.criteria.filter;

import lombok.Data;

import java.util.List;

@Data
public class Filter<T> {

    private T equals;
    private T notEquals;
    private Boolean specified;
    private List<T> in;
    private List<T> notIn;

}
