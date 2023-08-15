package com.arcone.learning.controller;


import com.arcone.learning.controller.dto.TaskLogDTO;
import com.arcone.learning.mapper.TaskLogMapper;
import com.arcone.learning.service.TaskLogService;
import com.arcone.learning.util.security.UserAuthentication;
import com.arcone.learning.validator.query.RequestQuerySizeListValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/users/courses/{courseId}/logs", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserCourseLogController {
    private final TaskLogService service;
    private final TaskLogMapper mapper;
    private final RequestQuerySizeListValidator validator;
    private final UserAuthentication authentication;

    @GetMapping
    public List<TaskLogDTO> findAll(@PathVariable String courseId, @RequestParam int start,
                                    @RequestParam(defaultValue = "20") int end) {
        validator.validate(start, end);
        return mapper.from(service.findAll(authentication.id(), courseId, start, end));
    }
}
