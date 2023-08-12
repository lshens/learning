package com.arcone.learning.service;

import com.arcone.learning.model.CoursePO;

import java.util.List;

public interface CourseService {
    CoursePO create(CoursePO course);

    CoursePO update(String id, CoursePO course);

    List<CoursePO> findAll(int start, int end);

    void sync();
}
