package com.arcone.learning.service;

import com.arcone.learning.model.AddressPO;

public interface AddressService {
    AddressPO create(String userId, AddressPO address);

    AddressPO update(String userId, AddressPO address);

    AddressPO find(String userId);
}
