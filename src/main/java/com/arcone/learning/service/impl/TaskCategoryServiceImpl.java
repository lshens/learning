package com.arcone.learning.service.impl;

import com.arcone.learning.model.TaskCategoryPO;
import com.arcone.learning.repository.TaskCategoryRepository;
import com.arcone.learning.service.TaskCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {
    private final TaskCategoryRepository repository;

    @Override
    public List<TaskCategoryPO> findAll(int start, int end) {
        return repository.findAll(of(start, end)).getContent();
    }
}
