package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.UserDTO;
import com.arcone.learning.model.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "status", ignore = true)
    UserPO to(UserDTO dto);

    @Mapping(target = "secret", ignore = true)
    UserDTO from(UserPO po);
}
