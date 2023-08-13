package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserCoursePOId {
    @Column(name = "course_id")
    private String courseId;
    @Column(name = "user_id")
    private String userId;
}
