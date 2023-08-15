package com.arcone.learning.service.impl;

import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.model.TaskLogPO;
import com.arcone.learning.repository.TaskLogRepository;
import com.arcone.learning.service.TaskCategoryService;
import com.arcone.learning.service.TaskLogService;
import com.arcone.learning.service.UserCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.LocalDateTime.now;
import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
public class TaskLogServiceImpl implements TaskLogService {
    private final TaskLogRepository repository;
    private final UserCourseService userCourseService;
    private final TaskCategoryService taskCategoryService;

    @Override
    public TaskLogPO create(String userId, String courseId, String categoryId, TaskLogPO log) {
        return save(userId, courseId, categoryId, log);
    }

    @Override
    public TaskLogPO update(String userId, String courseId, String categoryId, String id, TaskLogPO log) {
        find(userId, courseId, categoryId, id);
        log.setId(id);
        return save(userId, courseId, categoryId, log);
    }

    @Override
    public void delete(String userId, String courseId, String categoryId, String id) {
        repository.delete(find(userId, courseId, categoryId, id));
    }

    @Override
    public List<TaskLogPO> findAll(String userId, String courseId, int start, int end) {
        return repository.findAllByUserIdAndCourseId(userId, courseId, of(start, end)).getContent();
    }

    private TaskLogPO find(String userId, String courseId, String categoryId, String id) {
        return repository.findByIdAndUserIdAndCourseIdAndCategoryId(id, userId, courseId, categoryId)
                .orElseThrow(() -> new NotFoundException("The log does not exists"));
    }

    private TaskLogPO save(String userId, String courseId, String categoryId, TaskLogPO log) {
        exists(userId, courseId, categoryId);
        log.setUserId(userId);
        log.setCategoryId(categoryId);
        log.setCourseId(courseId);
        log.setChangeDateTime(now());
        return repository.save(log);
    }

    private void exists(String userId, String courseId, String categoryId) {
        userCourseService.exists(courseId, userId);
        taskCategoryService.exists(categoryId);
    }
}
