package com.arcone.learning.controller;


import com.arcone.learning.controller.dto.TaskLogDTO;
import com.arcone.learning.mapper.TaskLogMapper;
import com.arcone.learning.service.TaskLogService;
import com.arcone.learning.util.security.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/users/courses/{courseId}/task/{taskId}/logs", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserCourseTaskLogController {
    private final TaskLogService service;
    private final TaskLogMapper mapper;
    private final UserAuthentication authentication;

    @PostMapping
    public TaskLogDTO create(@PathVariable String courseId, @PathVariable String taskId, @Valid @RequestBody TaskLogDTO log) {
        return mapper.from(service.create(authentication.id(), courseId, taskId, mapper.to(log)));
    }

    @PutMapping("/{id}")
    public TaskLogDTO update(@PathVariable String courseId,
                             @PathVariable String taskId,
                             @PathVariable String id,
                             @Valid @RequestBody TaskLogDTO log) {
        return mapper.from(service.update(authentication.id(), courseId, taskId, id, mapper.to(log)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable String courseId, @PathVariable String taskId, @PathVariable String id) {
        service.delete(authentication.id(), courseId, taskId, id);
    }
}
