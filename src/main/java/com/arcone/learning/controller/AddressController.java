package com.arcone.learning.controller;

import com.arcone.learning.controller.dto.AddressDTO;
import com.arcone.learning.mapper.AddressMapper;
import com.arcone.learning.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(name = "/v1/addresses", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping
    public AddressDTO create(@RequestBody AddressDTO address) {
        return mapper.from(service.create("id from security", mapper.to(address)));
    }

    @PutMapping
    public AddressDTO update(@RequestBody AddressDTO address) {
        return mapper.from(service.update("id from security", mapper.to(address)));
    }

    @GetMapping
    public AddressDTO find() {
        return mapper.from(service.find("id from security"));
    }
}
