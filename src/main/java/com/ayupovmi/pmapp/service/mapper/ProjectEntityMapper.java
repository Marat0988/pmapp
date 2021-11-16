package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.ProjectEntity;
import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ProjectEntityMapper {

    public ProjectResponseDto projectEntityToProjectResponseDto (ProjectEntity projectEntity);
    public ProjectEntity projectRequestDtoToProjectEntity (ProjectRequestDto projectRequestDto);

    public List<ProjectResponseDto> projectEntityListToProjectResponseDtoList (Collection<ProjectEntity>
                                                                                       projectEntityList);

}
