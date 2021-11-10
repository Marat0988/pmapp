package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.entity.TaskEntity;
import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.repository.TaskRepository;
import com.ayupovmi.pmapp.rest.dto.TaskRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;
import com.ayupovmi.pmapp.service.TaskService;
import com.ayupovmi.pmapp.service.mapper.TaskEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskEntityMapper mapper = Mappers.getMapper(TaskEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public TaskResponseDto getById(Long id) {

        TaskEntity taskEntity = taskRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Task is not found with id: " + id));
        TaskResponseDto taskResponseDto = mapper.taskEntityToTaskResponseDto(taskEntity);


        return taskResponseDto;
    }
    @Transactional
    @Override
    public TaskResponseDto save(TaskRequestDto taskRequestDto) {
        TaskEntity taskEntity = mapper.taskRequestDtoToTaskEntity(taskRequestDto);
        taskRepository.save(taskEntity);
        TaskResponseDto taskResponseDto = mapper.taskEntityToTaskResponseDto(taskEntity);
        return taskResponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        taskRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponseDto> getAll() {
        List<TaskEntity> taskEntityList = taskRepository.findAll();
        List<TaskResponseDto> taskResponseDtoList = mapper.taskEntityListToTaskResponseDtoList(taskEntityList);
        return taskResponseDtoList;
    }

}
