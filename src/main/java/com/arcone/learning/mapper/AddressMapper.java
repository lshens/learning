package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.AddressDTO;
import com.arcone.learning.model.AddressPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AddressMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    AddressPO to(AddressDTO user);

    AddressDTO from(AddressPO addressPO);

    @Mapping(target = "id", ignore = true)
    AddressPO merge(AddressPO newest, @MappingTarget AddressPO oldest);
}
