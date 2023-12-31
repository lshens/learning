package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.AddressDTO;
import com.arcone.learning.mapper.AddressMapper;
import com.arcone.learning.service.AddressService;
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
@RequestMapping(value = "/v1/users/addresses", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class UserAddressController {
    private final AddressService service;
    private final AddressMapper mapper;
    private final UserAuthentication authentication;

    @PostMapping
    public AddressDTO create(@Valid @RequestBody AddressDTO address) {
        return mapper.from(service.create(authentication.id(), mapper.to(address)));
    }

    @PutMapping
    public AddressDTO update(@Valid @RequestBody AddressDTO address) {
        return mapper.from(service.update(authentication.id(), mapper.to(address)));
    }

    @GetMapping
    public AddressDTO find() {
        return mapper.from(service.find(authentication.id()));
    }
}
