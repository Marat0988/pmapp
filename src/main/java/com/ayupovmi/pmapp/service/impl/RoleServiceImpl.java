package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.entity.RoleEntity;
import com.ayupovmi.pmapp.repository.RoleRepository;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.service.RoleService;
import com.ayupovmi.pmapp.service.mapper.RoleEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private RoleEntityMapper mapper = Mappers.getMapper(RoleEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public RoleResponseDto getById(Long id) {

        RoleEntity roleEntity = roleRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Role is not found with id: " + id));
        RoleResponseDto roleResponseDto = mapper.roleEntityToRoleResponseDto(roleEntity);


        return roleResponseDto;
    }
    @Transactional
    @Override
    public RoleResponseDto save(RoleRequestDto roleRequestDto) {
        RoleEntity roleEntity = mapper.roleRequestDtoToRoleEntity(roleRequestDto);
        roleRepository.save(roleEntity);
        RoleResponseDto roleResponseDto = mapper.roleEntityToRoleResponseDto(roleEntity);
        return roleResponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        roleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleResponseDto> getAll() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleResponseDto> roleResponseDtoList = mapper.roleEntityListToRoleResponseDtoList(roleEntityList);
        return roleResponseDtoList;
    }
}
