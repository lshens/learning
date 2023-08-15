package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.UserDTO;
import com.arcone.learning.mapper.UserMapper;
import com.arcone.learning.service.UserService;
import com.arcone.learning.util.security.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/users", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService service;
    private final UserMapper mapper;
    private final UserAuthentication authentication;

    @PostMapping("/sig-in")
    public UserDTO create(@Valid @RequestBody UserDTO user) {
        return mapper.from(service.create(mapper.to(user)));
    }

    @PutMapping
    public UserDTO update(@Valid @RequestBody UserDTO user) {
        user.setId(authentication.id());
        return mapper.from(service.update(mapper.to(user)));
    }

    @GetMapping
    public UserDTO find() {
        return mapper.from(service.find(authentication.id()));
    }
}
