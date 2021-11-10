package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.TaskTypeRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskTypeResponseDto;

import java.util.List;

public interface TaskTypeService {
    TaskTypeResponseDto getById(Long id);

    TaskTypeResponseDto save (TaskTypeRequestDto taskTypeRequestDto);

    void delete (Long id);

    List<TaskTypeResponseDto> getAll();
}
