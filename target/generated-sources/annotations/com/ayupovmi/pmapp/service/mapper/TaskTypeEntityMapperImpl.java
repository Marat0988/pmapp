package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.TaskTypeEntity;
import com.ayupovmi.pmapp.rest.dto.TaskTypeRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskTypeResponseDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T02:11:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class TaskTypeEntityMapperImpl implements TaskTypeEntityMapper {

    @Override
    public TaskTypeResponseDto taskTypeEntityToTaskTypeResponseDto(TaskTypeEntity taskTypeEntity) {
        if ( taskTypeEntity == null ) {
            return null;
        }

        TaskTypeResponseDto taskTypeResponseDto = new TaskTypeResponseDto();

        taskTypeResponseDto.setName( taskTypeEntity.getName() );

        return taskTypeResponseDto;
    }

    @Override
    public TaskTypeEntity taskTypeRequestDtoToTaskTypeEntity(TaskTypeRequestDto taskTypeRequestDto) {
        if ( taskTypeRequestDto == null ) {
            return null;
        }

        TaskTypeEntity taskTypeEntity = new TaskTypeEntity();

        taskTypeEntity.setTaskTypeId( taskTypeRequestDto.getTaskTypeId() );
        taskTypeEntity.setName( taskTypeRequestDto.getName() );

        return taskTypeEntity;
    }

    @Override
    public List<TaskTypeResponseDto> taskTypeEntityListToTaskTypeResponseDtoList(Collection<TaskTypeEntity> taskTypeEntityList) {
        if ( taskTypeEntityList == null ) {
            return null;
        }

        List<TaskTypeResponseDto> list = new ArrayList<TaskTypeResponseDto>( taskTypeEntityList.size() );
        for ( TaskTypeEntity taskTypeEntity : taskTypeEntityList ) {
            list.add( taskTypeEntityToTaskTypeResponseDto( taskTypeEntity ) );
        }

        return list;
    }
}
