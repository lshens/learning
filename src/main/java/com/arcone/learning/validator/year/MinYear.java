package com.arcone.learning.validator.year;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {MinYearValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MinYear {
    String message() default "The minimum year of 16 is required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value() default 16;
}
