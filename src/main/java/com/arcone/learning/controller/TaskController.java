package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.TaskDTO;
import com.arcone.learning.mapper.TaskCategoryMapper;
import com.arcone.learning.service.TaskCategoryService;
import com.arcone.learning.validator.query.RequestQuerySizeListValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/tasks", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class TaskController {
    private final TaskCategoryService service;
    private final TaskCategoryMapper mapper;
    private final RequestQuerySizeListValidator validator;

    @GetMapping
    public List<TaskDTO> findAll(@RequestParam int start,
                                 @RequestParam(defaultValue = "20") int end) {
        validator.validate(start, end);
        return mapper.from(service.findAll(start, end));
    }
}
