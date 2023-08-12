package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.CourseDTO;
import com.arcone.learning.mapper.CourseMapper;
import com.arcone.learning.service.CourseService;
import com.arcone.learning.validator.query.RequestQuerySizeListValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(name = "/v1/courses", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService service;
    private final CourseMapper mapper;
    private final RequestQuerySizeListValidator validator;

    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO course) {
        return mapper.from(service.create(mapper.to(course)));
    }

    @PutMapping("/{id}")
    public CourseDTO update(@RequestBody CourseDTO course, @PathVariable String id) {
        return mapper.from(service.update(id, mapper.to(course)));
    }

    @GetMapping
    public List<CourseDTO> findAll(@RequestParam int start,
                                   @RequestParam(defaultValue = "20") int end) {
        validator.validate(start, end);
        return mapper.from(service.findAll(start, end));
    }
}
