package com.ayupovmi.pmapp.service.impl;

import com.ayupovmi.pmapp.entity.UserEntity;
import com.ayupovmi.pmapp.exception.ResourceNotFoundException;
import com.ayupovmi.pmapp.rest.dto.UserRequestDto;
import com.ayupovmi.pmapp.rest.dto.UserResponseDto;
import com.ayupovmi.pmapp.repository.UserRepository;
import com.ayupovmi.pmapp.service.UserService;
import com.ayupovmi.pmapp.service.mapper.UserEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserEntityMapper mapper = Mappers.getMapper(UserEntityMapper.class);

    @Transactional(readOnly = true)
    @Override

    public UserResponseDto getById(Long id) {

        UserEntity userEntity = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User is not found with id: " + id));
        UserResponseDto userResponseDto = mapper.userEntityToUserResponseDto(userEntity);

        return userResponseDto;
    }
    @Transactional
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        UserEntity userEntity = mapper.userRequestDtoToUserEntity(userRequestDto);
        userRepository.save(userEntity);
        UserResponseDto userResponseDto = mapper.userEntityToUserResponseDto(userEntity);
        return userResponseDto;

    }
    @Transactional
    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserResponseDto> getAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = mapper.userEntityListToUserResponseDtoList(userEntityList);
        return userResponseDtoList;
    }

}