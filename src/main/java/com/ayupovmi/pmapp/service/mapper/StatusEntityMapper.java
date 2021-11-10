package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.entity.StatusEntity;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusReponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusRequestDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface StatusEntityMapper {

    public StatusReponseDto statusEntityToStatusResponseDto (StatusEntity statusEntity);
    public StatusEntity statusRequestDtoToStatusEntity (StatusRequestDto statusRequestDto);

    public List<StatusReponseDto> statusEntityListToStatusResponseDtoList (Collection<StatusEntity>
                                                                              statusEntityList);
}
