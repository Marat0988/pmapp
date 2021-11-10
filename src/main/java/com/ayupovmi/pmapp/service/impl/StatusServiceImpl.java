package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.entity.StatusEntity;
import com.ayupovmi.pmapp.repository.StatusRepository;
import com.ayupovmi.pmapp.rest.dto.StatusReponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusRequestDto;
import com.ayupovmi.pmapp.service.StatusService;
import com.ayupovmi.pmapp.service.mapper.StatusEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
    public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    private StatusEntityMapper mapper = Mappers.getMapper(StatusEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public StatusReponseDto getById(Long id) {

        StatusEntity statusEntity = statusRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Status is not found with id: " + id));
        StatusReponseDto statusReponseDto = mapper.statusEntityToStatusResponseDto(statusEntity);


        return statusReponseDto;
    }
    @Transactional
    @Override
    public StatusReponseDto save(StatusRequestDto statusRequestDto) {
        StatusEntity statusEntity = mapper.statusRequestDtoToStatusEntity(statusRequestDto);
        statusRepository.save(statusEntity);
        StatusReponseDto statusReponseDto = mapper.statusEntityToStatusResponseDto(statusEntity);
        return statusReponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        statusRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StatusReponseDto> getAll() {
        List<StatusEntity> statusEntityList = statusRepository.findAll();
        List<StatusReponseDto> statusReponseDtoList = mapper.statusEntityListToStatusResponseDtoList(statusEntityList);
        return statusReponseDtoList;
    }
    }

