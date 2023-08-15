package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static com.arcone.learning.util.IdUtil.uuid;
import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class CoursePO {
    @Id
    @Builder.Default
    private String id = uuid();
    private String name;
    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;
    @Enumerated(STRING)
    private CourseStatusEnum status;
}
