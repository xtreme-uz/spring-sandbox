package com.example.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@NotBlank
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ProductValidator.class})
@Documented
public @interface ProductRegion {

    String message() default "invalid region key";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

