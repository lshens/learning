package com.arcone.learning.controller.dto;

import com.arcone.learning.validator.time.TimeInterval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskLogDTO {
    private String id;
    @PastOrPresent
    private LocalDate date;
    @TimeInterval
    private LocalTime time;
}
