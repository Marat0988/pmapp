package com.ayupovmi.pmapp.service;

import com.ayupovmi.pmapp.rest.dto.ReleaseRequestDto;
import com.ayupovmi.pmapp.rest.dto.ReleaseResponseDto;

import java.util.List;

public interface ReleaseService {
    ReleaseResponseDto getById(Long id);

    ReleaseResponseDto save (ReleaseRequestDto releaseRequestDto);

    void delete (Long id);

    List<ReleaseResponseDto> getAll();
}
