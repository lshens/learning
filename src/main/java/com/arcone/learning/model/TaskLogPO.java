package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.arcone.learning.util.IdUtil.uuid;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "task_logs")
public class TaskLogPO {

    @Id
    @Builder.Default
    private String id = uuid();
    @Column(name = "change_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime changeDateTime;
    @Column(name = "input_date", columnDefinition = "DATE")
    private LocalDate inputDate;
    @Column(name = "input_time", columnDefinition = "TIME")
    private LocalTime inputTime;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "course_id")
    private String courseId;
}
