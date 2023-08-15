package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.UserDTO;
import com.arcone.learning.model.UserPO;
import liquibase.pro.packaged.M;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    UserPO to(UserDTO dto);

    @Mapping(target = "secret", ignore = true)
    UserDTO from(UserPO po);
}
