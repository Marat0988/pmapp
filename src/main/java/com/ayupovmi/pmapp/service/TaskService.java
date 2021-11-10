package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;
import com.ayupovmi.pmapp.rest.dto.TaskRequestDto;
import com.ayupovmi.pmapp.rest.dto.TaskResponseDto;

import java.util.List;


public interface TaskService {

   TaskResponseDto getById(Long id);

    TaskResponseDto save (TaskRequestDto taskRequestDto);

    void delete (Long id);

    List<TaskResponseDto> getAll();

 }
