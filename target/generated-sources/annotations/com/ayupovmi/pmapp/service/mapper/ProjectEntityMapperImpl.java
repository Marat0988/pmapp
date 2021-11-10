package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.ProjectEntity;
import com.ayupovmi.pmapp.rest.dto.ProjectRequestDto;
import com.ayupovmi.pmapp.rest.dto.ProjectResponseDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T02:11:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class ProjectEntityMapperImpl implements ProjectEntityMapper {

    @Override
    public ProjectResponseDto projectEntityToProjectResponseDto(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();

        projectResponseDto.setName( projectEntity.getName() );
        projectResponseDto.setIsPaid( projectEntity.getIsPaid() );

        return projectResponseDto;
    }

    @Override
    public ProjectEntity projectRequestDtoToProjectEntity(ProjectRequestDto projectRequestDto) {
        if ( projectRequestDto == null ) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setProjectId( projectRequestDto.getProjectId() );
        projectEntity.setName( projectRequestDto.getName() );

        return projectEntity;
    }

    @Override
    public List<ProjectResponseDto> projectEntityListToProjectResponseDtoList(Collection<ProjectEntity> projectEntityList) {
        if ( projectEntityList == null ) {
            return null;
        }

        List<ProjectResponseDto> list = new ArrayList<ProjectResponseDto>( projectEntityList.size() );
        for ( ProjectEntity projectEntity : projectEntityList ) {
            list.add( projectEntityToProjectResponseDto( projectEntity ) );
        }

        return list;
    }
}
