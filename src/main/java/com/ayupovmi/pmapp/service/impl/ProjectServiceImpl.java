package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.entity.ProjectEntity;
import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;
import com.ayupovmi.pmapp.repository.ProjectRepository;
import com.ayupovmi.pmapp.service.ProjectService;
import com.ayupovmi.pmapp.service.mapper.ProjectEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private ProjectEntityMapper mapper = Mappers.getMapper(ProjectEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public ProjectResponseDto getById(Long id) {

        ProjectEntity projectEntity = projectRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project is not found with id: " + id));
        ProjectResponseDto projectResponseDto = mapper.projectEntityToProjectResponseDto(projectEntity);

        return projectResponseDto;
    }
    @Transactional
    @Override
    public ProjectResponseDto save(ProjectRequestDto projectRequestDto) {
        ProjectEntity projectEntity = mapper.projectRequestDtoToProjectEntity(projectRequestDto);
        projectRepository.save(projectEntity);
        ProjectResponseDto projectResponseDto = mapper.projectEntityToProjectResponseDto(projectEntity);
        return projectResponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        projectRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProjectResponseDto> getAll() {
        List<ProjectEntity> projectEntityList = projectRepository.findAll();
        List<ProjectResponseDto> projectResponseDtoList = mapper.projectEntityListToProjectResponseDtoList(projectEntityList);
        return projectResponseDtoList;
    }

}
