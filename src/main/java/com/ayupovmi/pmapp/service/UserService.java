package com.ayupovmi.pmapp.service;


import com.ayupovmi.pmapp.rest.dto.UserRequestDto;
import com.ayupovmi.pmapp.rest.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto getById(Long id);

    UserResponseDto save (UserRequestDto userRequestDto);

    void delete (Long id);

    List<UserResponseDto> getAll();
}
