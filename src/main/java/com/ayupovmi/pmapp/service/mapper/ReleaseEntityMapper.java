package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.ReleaseEntity;
import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.rest.dto.ReleaseRequestDto;
import com.ayupovmi.pmapp.rest.dto.ReleaseResponseDto;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ReleaseEntityMapper {

    public ReleaseResponseDto releaseEntityToReleaseResponseDto (ReleaseEntity releaseEntity);
    public  ReleaseEntity  releaseRequestDtoToReleaseEntity ( ReleaseRequestDto  releaseRequestDto);

    public List< ReleaseResponseDto>  releaseEntityListToReleaseResponseDtoList (Collection< ReleaseEntity>
                                                                                         ReleaseEntityList);
}
