package com.arcone.learning.validator.time;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

import static java.util.Objects.isNull;

public class TimeIntervalValidator implements ConstraintValidator<TimeInterval, LocalTime> {

    private int minutes;

    @Override
    public void initialize(TimeInterval minutes) {
        this.minutes = minutes.value();
    }

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        if (isNull(value)) {
            return false;
        }
        int minute = value.getMinute();
        return minute >= 0 && minute < this.minutes;
    }
}
