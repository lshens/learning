package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.CourseDTO;
import com.arcone.learning.model.CoursePO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CourseMapper {

    CoursePO to(CourseDTO dto);

    CourseDTO from(CoursePO po);

    List<CourseDTO> from(List<CoursePO> pos);

    @Mapping(target = "id", ignore = true)
    CoursePO merge(CoursePO newest, @MappingTarget CoursePO oldest);
}
