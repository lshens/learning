package com.arcone.learning.service;

import com.arcone.learning.model.CoursePO;

import java.util.List;

public interface UserCourseService {
    List<CoursePO> findAll(String userId, int start, int end);
}
