package com.example.specification.criteria;

import com.example.specification.criteria.filter.BigDecimalFilter;
import com.example.specification.criteria.filter.LongFilter;
import com.example.specification.criteria.filter.StringFilter;
import lombok.Data;

@Data
public class ProductCriteria {

    private LongFilter id;

    private StringFilter name;

    private BigDecimalFilter cost;

    private LongFilter quantity;

}
