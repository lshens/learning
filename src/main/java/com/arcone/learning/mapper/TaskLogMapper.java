package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.TaskLogDTO;
import com.arcone.learning.model.TaskLogPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TaskLogMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "changeDateTime", ignore = true)
    @Mapping(target = "categoryId", ignore = true)
    @Mapping(target = "inputTime", source = "time")
    @Mapping(target = "inputDate", source = "date")
    TaskLogPO to(TaskLogDTO log);

    @Mapping(target = "time", source = "inputTime")
    @Mapping(target = "date", source = "inputDate")
    TaskLogDTO from(TaskLogPO po);

    @Mapping(target = "time", source = "inputTime")
    @Mapping(target = "date", source = "inputDate")
    List<TaskLogDTO> from(List<TaskLogPO> pos);
}
