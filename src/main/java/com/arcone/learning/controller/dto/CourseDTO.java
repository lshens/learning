package com.arcone.learning.controller.dto;

import com.arcone.learning.model.CourseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    private String id;
    @NotBlank
    private String name;
    @NotNull
    @FutureOrPresent
    private LocalDate startDate;
    private CourseStatusEnum status;
}
