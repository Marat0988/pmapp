package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.entity.ReleaseEntity;
import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.repository.ReleaseRepository;
import com.ayupovmi.pmapp.repository.RoleRepository;
import com.ayupovmi.pmapp.rest.dto.ReleaseRequestDto;
import com.ayupovmi.pmapp.rest.dto.ReleaseResponseDto;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.service.ReleaseService;
import com.ayupovmi.pmapp.service.mapper.ReleaseEntityMapper;
import com.ayupovmi.pmapp.service.mapper.RoleEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ReleaseServiceImpl implements ReleaseService {
    private ReleaseRepository releaseRepository;
    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    private ReleaseEntityMapper mapper = Mappers.getMapper(ReleaseEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public ReleaseResponseDto getById(Long id) {

        ReleaseEntity releaseEntity = releaseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Release is not found with id: " + id));
        ReleaseResponseDto releaseResponseDto = mapper.releaseEntityToReleaseResponseDto(releaseEntity);


        return releaseResponseDto;
    }
    @Transactional
    @Override
    public ReleaseResponseDto save(ReleaseRequestDto releaseRequestDto) {
        ReleaseEntity releaseEntity = mapper.releaseRequestDtoToReleaseEntity(releaseRequestDto);
        releaseRepository.save(releaseEntity);
        ReleaseResponseDto releaseResponseDto = mapper.releaseEntityToReleaseResponseDto(releaseEntity);
        return releaseResponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        releaseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReleaseResponseDto> getAll() {
        List<ReleaseEntity> releaseEntityList = releaseRepository.findAll();
        List<ReleaseResponseDto> releaseResponseDtoList = mapper.releaseEntityListToReleaseResponseDtoList(releaseEntityList);
        return releaseResponseDtoList;

    }
}
