package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.arcone.learning.util.IdUtil.uuid;
import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "task_categories")
public class TaskCategoryPO {
    @Id
    @Builder.Default
    private String id = uuid();
    private String description;
    @Enumerated(STRING)
    private TaskCategoryTypeEnum type;
}
