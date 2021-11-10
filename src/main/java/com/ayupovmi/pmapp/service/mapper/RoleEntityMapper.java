package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface RoleEntityMapper {
    public RoleResponseDto roleEntityToRoleResponseDto (RoleEntity roleEntity);
    public RoleEntity roleRequestDtoToRoleEntity (RoleRequestDto roleRequestDto);

    public List<RoleResponseDto> roleEntityListToRoleResponseDtoList (Collection<RoleEntity>
                                                                                          roleEntityList);
}
