package com.arcone.learning.builder;

import com.arcone.learning.model.CourseStatusEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.arcone.learning.model.CourseStatusEnum.EXPIRED;
import static com.arcone.learning.model.CourseStatusEnum.IN_PROGRESS;
import static com.arcone.learning.model.CourseStatusEnum.QUEUE;
import static java.time.LocalDate.now;
import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CourseStatusBuilder {
    private LocalDate startDate;
    private int monthsToExpire = 6;

    public static CourseStatusBuilder builder() {
        return new CourseStatusBuilder();
    }

    public CourseStatusBuilder start(LocalDate date) {
        this.startDate = date;
        return this;
    }

    public CourseStatusBuilder monthsToExpire(int months) {
        this.monthsToExpire = months;
        return this;
    }

    public CourseStatusEnum build() {
        if (isNull(startDate)) {
            throw new IllegalArgumentException("The start date of a course is required for having a status");
        }
        if (startDate.isBefore(now())) {
            return QUEUE;
        } else if (startDate.isAfter(startDate.plusMonths(monthsToExpire))) {
            return EXPIRED;
        }
        return IN_PROGRESS;
    }
}
