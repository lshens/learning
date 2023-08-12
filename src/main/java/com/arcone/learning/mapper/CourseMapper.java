package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.CourseDTO;
import com.arcone.learning.model.CoursePO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CourseMapper {

    CoursePO to(CourseDTO dto);

    CourseDTO from(CoursePO po);

    List<CourseDTO> from(List<CoursePO> pos);

    @Mapping(target = "id", ignore = true)
    CoursePO merge(CoursePO newest, CoursePO oldest);
}
