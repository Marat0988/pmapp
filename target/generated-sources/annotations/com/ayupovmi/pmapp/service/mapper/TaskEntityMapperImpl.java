package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.TaskEntity;
import com.ayupovmi.pmapp.rest.dto.TaskRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T02:11:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class TaskEntityMapperImpl implements TaskEntityMapper {

    @Override
    public TaskResponseDto taskEntityToTaskResponseDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setName( taskEntity.getName() );
        taskResponseDto.setDescription( taskEntity.getDescription() );
        taskResponseDto.setSubmissionDate( taskEntity.getSubmissionDate() );
        taskResponseDto.setStartDate( taskEntity.getStartDate() );

        return taskResponseDto;
    }

    @Override
    public TaskEntity taskRequestDtoToTaskEntity(TaskRequestDto taskRequestDto) {
        if ( taskRequestDto == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setTaskId( taskRequestDto.getTaskId() );
        taskEntity.setName( taskRequestDto.getName() );

        return taskEntity;
    }

    @Override
    public List<TaskResponseDto> taskEntityListToTaskResponseDtoList(Collection<TaskEntity> taskEntityList) {
        if ( taskEntityList == null ) {
            return null;
        }

        List<TaskResponseDto> list = new ArrayList<TaskResponseDto>( taskEntityList.size() );
        for ( TaskEntity taskEntity : taskEntityList ) {
            list.add( taskEntityToTaskResponseDto( taskEntity ) );
        }

        return list;
    }
}
