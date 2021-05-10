package com.example.validation.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {DateRangeValidator.class})
@Documented
public @interface DateRange {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Invalid range between dates";

    String fromDate() default "fromDate";

    String toDate() default "toDate";
}

class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String fromDate;
    private String toDate;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.fromDate = constraintAnnotation.fromDate();
        this.toDate = constraintAnnotation.toDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Class<?> clazz = value.getClass();
        try {
            var m1 = clazz.getMethod(getMethodByField(fromDate), (Class<?>[]) null);
            var m2 =clazz.getMethod(getMethodByField(toDate), (Class<?>[]) null);

            final OffsetDateTime date1 = (OffsetDateTime) m1.invoke(value, (Object[]) null);
            final OffsetDateTime date2 = (OffsetDateTime) m2.invoke(value, (Object[]) null);

            if(date1 != null && date2 != null && date1.isBefore(date2))
                return true;

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getMethodByField(String field) {
        return "get" +
                field.substring(0, 1).toUpperCase() +
                field.substring(1);
    }
}
