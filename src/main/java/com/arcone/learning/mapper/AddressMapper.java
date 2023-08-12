package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.AddressDTO;
import com.arcone.learning.model.AddressPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressMapper {
    AddressPO to(AddressDTO user);

    AddressDTO from(AddressPO addressPO);

    @Mapping(target = "id", ignore = true)
    AddressPO merge(AddressPO newest, AddressPO oldest);
}
