package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.entity.TaskTypeEntity;
import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.repository.TaskTypeRepository;
import com.ayupovmi.pmapp.rest.dto.TaskTypeRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskTypeResponseDto;
import com.ayupovmi.pmapp.service.TaskTypeService;
import com.ayupovmi.pmapp.service.mapper.TaskTypeEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TaskTypeServiceImpl implements TaskTypeService {

    private TaskTypeRepository taskTypeRepository;
    public TaskTypeServiceImpl(TaskTypeRepository taskTypeRepository) {
        this.taskTypeRepository = taskTypeRepository;
    }

    private TaskTypeEntityMapper mapper = Mappers.getMapper(TaskTypeEntityMapper.class);

    @Transactional(readOnly = true)
    @Override
    public TaskTypeResponseDto getById(Long id) {
        TaskTypeEntity taskTypeEntity = taskTypeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("TaskType is not found with id: " + id));
        TaskTypeResponseDto taskTypeResponseDto = mapper.taskTypeEntityToTaskTypeResponseDto(taskTypeEntity);
        return taskTypeResponseDto;
    }

    @Transactional
    @Override
    public TaskTypeResponseDto save(TaskTypeRequestDto taskTypeRequestDto) {
        TaskTypeEntity taskTypeEntity = mapper.taskTypeRequestDtoToTaskTypeEntity(taskTypeRequestDto);
        taskTypeRepository.save(taskTypeEntity);
        TaskTypeResponseDto taskTypeResponseDto = mapper.taskTypeEntityToTaskTypeResponseDto(taskTypeEntity);
        return taskTypeResponseDto;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        taskTypeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TaskTypeResponseDto> getAll() {
        List<TaskTypeEntity> taskTypeEntityList = taskTypeRepository.findAll();
        List<TaskTypeResponseDto> taskTypeResponseDtoList = mapper.
                taskTypeEntityListToTaskTypeResponseDtoList(taskTypeEntityList);
        return taskTypeResponseDtoList;
    }
}

