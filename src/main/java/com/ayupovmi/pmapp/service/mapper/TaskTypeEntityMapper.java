package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.TaskTypeEntity;
import com.ayupovmi.pmapp.rest.dto.TaskTypeRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskTypeResponseDto;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TaskTypeEntityMapper {
    public TaskTypeResponseDto taskTypeEntityToTaskTypeResponseDto (TaskTypeEntity taskTypeEntity);
    public TaskTypeEntity taskTypeRequestDtoToTaskTypeEntity (TaskTypeRequestDto taskTypeRequestDto);

    public List<TaskTypeResponseDto> taskTypeEntityListToTaskTypeResponseDtoList (Collection<TaskTypeEntity>
                                                                                  taskTypeEntityList);
}
