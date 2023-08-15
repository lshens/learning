package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.CourseDTO;
import com.arcone.learning.mapper.CourseMapper;
import com.arcone.learning.service.UserCourseService;
import com.arcone.learning.util.security.UserAuthentication;
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
@RequestMapping(value = "/v1/users/courses", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserCourseController {
    private final UserCourseService service;
    private final CourseMapper mapper;
    private final RequestQuerySizeListValidator validator;
    private final UserAuthentication authentication;

    @GetMapping
    public List<CourseDTO> findAll(@RequestParam int start,
                                   @RequestParam(defaultValue = "20") int end) {
        validator.validate(start, end);
        return mapper.from(service.findAll(authentication.id(), start, end));
    }
}
