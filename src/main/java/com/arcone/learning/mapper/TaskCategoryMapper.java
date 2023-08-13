package com.arcone.learning.mapper;

import com.arcone.learning.controller.dto.TaskDTO;
import com.arcone.learning.model.TaskCategoryPO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TaskCategoryMapper {

    List<TaskDTO> from(List<TaskCategoryPO> pos);
}
