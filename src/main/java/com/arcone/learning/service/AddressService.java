package com.arcone.learning.service;

import com.arcone.learning.model.AddressPO;

public interface AddressService {
    AddressPO create(AddressPO address);

    AddressPO update(AddressPO address);

    AddressPO find(String userId);
}
