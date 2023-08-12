package com.arcone.learning.validator.query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

@Component
public class RequestQuerySizeListValidator {
    @Value("${learning.request.query.list.max-size:20}")
    private int maxSize;

    public void validate(int start, int end) {
        if (start < 0) {
            throw new ValidationException("The param start cannot be negative number");
        }

        if (end < 0) {
            throw new ValidationException("The param start cannot be negative number");
        }

        if (start >= end) {
            throw new ValidationException("The param start cannot be equal or higher than the param end");
        }

        final int diff = start - end;
        if (diff > maxSize) {
            throw new ValidationException(
                    "The max size to query is " + maxSize +
                            ", which is lower than the difference between start and end params, which is " + diff);
        }
    }
}
