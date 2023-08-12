package com.arcone.learning.service.impl;

import com.arcone.learning.model.AddressPO;
import com.arcone.learning.repository.AddressRepository;
import com.arcone.learning.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Override
    public AddressPO create(AddressPO address) {
        return null;
    }

    @Override
    public AddressPO update(AddressPO address) {
        return null;
    }

    @Override
    public AddressPO find(String userId) {
        return null;
    }
}
