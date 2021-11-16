package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    ProjectResponseDto getById(Long id);

    ProjectResponseDto save (ProjectRequestDto projectRequestDto);

    void delete (Long id);

    List<ProjectResponseDto> getAll();
}
