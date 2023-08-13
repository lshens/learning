package com.arcone.learning.controller.dto;

import com.arcone.learning.model.TaskCategoryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private String id;
    private String description;
    private TaskCategoryTypeEnum type;
}
