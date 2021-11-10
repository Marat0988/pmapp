package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.entity.StatusEntity;
import com.ayupovmi.pmapp.rest.dto.RoleRequestDto;
import com.ayupovmi.pmapp.rest.dto.RoleResponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusReponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusRequestDto;

import java.util.List;


public interface StatusService {
    StatusReponseDto getById(Long id);

    StatusReponseDto save(StatusRequestDto statusRequestDto);

    void delete(Long id);

    List<StatusReponseDto> getAll();

}
