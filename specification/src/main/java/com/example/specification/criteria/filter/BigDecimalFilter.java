package com.example.specification.criteria.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class BigDecimalFilter extends RangeFilter<BigDecimal> {

}
