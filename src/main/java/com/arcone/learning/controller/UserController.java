package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.UserDTO;
import com.arcone.learning.mapper.UserMapper;
import com.arcone.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(name = "/v1/users", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @PostMapping
    public UserDTO create(@RequestBody UserDTO user) {
        return mapper.from(service.create(mapper.to(user)));
    }
}
