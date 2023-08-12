package com.arcone.learning.service.impl;

import com.arcone.learning.exception.ConflictException;
import com.arcone.learning.exception.NotFoundException;
import com.arcone.learning.mapper.AddressMapper;
import com.arcone.learning.model.AddressPO;
import com.arcone.learning.repository.AddressRepository;
import com.arcone.learning.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressPO create(String userId, AddressPO address) {
        address.setUserId(userId);
        repository.findByUserId(userId).ifPresentOrElse(po -> {
                    throw new ConflictException("The user already have an address");
                },
                () -> save(address));
        return address;
    }

    @Override
    public AddressPO update(String userId, AddressPO address) {
        return save(mapper.merge(address, find(userId)));
    }

    @Override
    public AddressPO find(String userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("The user does not have an address"));
    }

    private AddressPO save(AddressPO address) {
        return repository.save(address);
    }
}
