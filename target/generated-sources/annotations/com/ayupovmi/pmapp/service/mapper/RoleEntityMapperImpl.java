package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T00:07:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class RoleEntityMapperImpl implements RoleEntityMapper {

    @Override
    public RoleResponseDto roleEntityToRoleResponseDto(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleResponseDto roleResponseDto = new RoleResponseDto();

        roleResponseDto.setName( roleEntity.getName() );

        return roleResponseDto;
    }

    @Override
    public RoleEntity roleRequestDtoToRoleEntity(RoleRequestDto roleRequestDto) {
        if ( roleRequestDto == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setRoleId( roleRequestDto.getRoleId() );
        roleEntity.setName( roleRequestDto.getName() );

        return roleEntity;
    }

    @Override
    public List<RoleResponseDto> roleEntityListToRoleResponseDtoList(Collection<RoleEntity> roleEntityList) {
        if ( roleEntityList == null ) {
            return null;
        }

        List<RoleResponseDto> list = new ArrayList<RoleResponseDto>( roleEntityList.size() );
        for ( RoleEntity roleEntity : roleEntityList ) {
            list.add( roleEntityToRoleResponseDto( roleEntity ) );
        }

        return list;
    }
}
