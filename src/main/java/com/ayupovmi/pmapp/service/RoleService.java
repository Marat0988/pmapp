package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;

import java.util.List;


public interface RoleService {
    RoleResponseDto getById(Long id);

    RoleResponseDto save(RoleRequestDto roleRequestDto);

    void delete(Long id);

    List<RoleResponseDto> getAll();
}
