package com.arcone.learning.service;

import com.arcone.learning.model.TaskLogPO;

import java.util.List;

public interface TaskLogService {
    TaskLogPO create(String userId, String courseId, String taskId, TaskLogPO log);

    TaskLogPO update(String userId, String courseId, String taskId,  String id, TaskLogPO log);

    void delete(String userId, String courseId, String taskId, String id);

    List<TaskLogPO> findAll(String userId, String courseId, int start, int end);
}
