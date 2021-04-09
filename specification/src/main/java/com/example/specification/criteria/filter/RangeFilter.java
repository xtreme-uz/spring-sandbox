package com.example.specification.criteria.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RangeFilter<T extends Comparable<? super T>> extends Filter<T> {

    private T greaterThan;

    private T lessThan;

    private T greaterThanOrEqual;

    private T lessThanOrEqual;

}
