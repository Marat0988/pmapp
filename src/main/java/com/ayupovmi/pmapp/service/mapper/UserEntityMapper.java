package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.UserEntity;
import com.ayupovmi.pmapp.rest.dto.UserRequestDto;
import com.ayupovmi.pmapp.rest.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserEntityMapper {
    public UserResponseDto userEntityToUserResponseDto (UserEntity userEntity);
    public UserEntity userRequestDtoToUserEntity (UserRequestDto userRequestDto);

    public List<UserResponseDto> userEntityListToUserResponseDtoList (Collection<UserEntity>
                                                                              userEntityList);
}
