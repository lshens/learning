package com.arcone.learning.validator.time;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {TimeIntervalValidator.class})
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeInterval {
    String message() default "The time must be within 30 minutes";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value() default 30;
}
