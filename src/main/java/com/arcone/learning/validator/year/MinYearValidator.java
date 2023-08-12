package com.arcone.learning.validator.year;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

import static java.util.Objects.isNull;

public class MinYearValidator implements ConstraintValidator<MinYear, LocalDate> {

    private int min;

    @Override
    public void initialize(MinYear minYear) {
        this.min = minYear.value();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (isNull(value)) {
            return false;
        }
        return Period.between(value, LocalDate.now()).getYears() >= min;
    }
}
