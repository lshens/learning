package com.arcone.learning.service;

import com.arcone.learning.model.TaskCategoryPO;

import java.util.List;

public interface TaskCategoryService {
    List<TaskCategoryPO> findAll(int start, int end);

    void exists(String id);
}
