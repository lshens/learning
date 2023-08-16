package com.arcone.learning.controller;


import com.arcone.learning.util.security.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/users/levels", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserLevelController {
    private final UserAuthentication authentication;

    @GetMapping
    public List<String> findAll() {
        return authentication.authorities();
    }
}
