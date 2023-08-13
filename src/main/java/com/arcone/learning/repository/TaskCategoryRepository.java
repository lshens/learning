package com.arcone.learning.repository;

import com.arcone.learning.model.TaskCategoryPO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends PagingAndSortingRepository<TaskCategoryPO, String> {
}
