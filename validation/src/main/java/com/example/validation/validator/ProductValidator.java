package com.example.validation.validator;

import com.example.validation.domain.Regions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ProductRegion, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            Regions.valueOf(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
