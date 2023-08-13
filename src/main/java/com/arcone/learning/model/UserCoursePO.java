package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_courses")
public class UserCoursePO {
    @EmbeddedId
    private UserCoursePOId id;
    @OneToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private CoursePO course;
}
