package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.TaskEntity;
import com.ayupovmi.pmapp.rest.dto.TaskRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface TaskEntityMapper {
    public TaskResponseDto taskEntityToTaskResponseDto (TaskEntity taskEntity);
    public TaskEntity taskRequestDtoToTaskEntity (TaskRequestDto taskRequestDto);

    public List<TaskResponseDto> taskEntityListToTaskResponseDtoList (Collection<TaskEntity>
                                                                                       taskEntityList);
}
