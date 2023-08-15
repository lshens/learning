package com.arcone.learning.repository;

import com.arcone.learning.model.TaskLogPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskLogRepository extends PagingAndSortingRepository<TaskLogPO, String> {
    Optional<TaskLogPO> findByIdAndUserIdAndCourseIdAndCategoryId(String id, String userId, String courseId, String categoryId);

    Page<TaskLogPO> findAllByUserIdAndCourseId(String userId, String courseId, Pageable pageable);
}
