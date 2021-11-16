package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.UserEntity;
import com.ayupovmi.pmapp.rest.dto.UserRequestDto;
import com.ayupovmi.pmapp.rest.dto.UserResponseDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T00:07:39+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class UserEntityMapperImpl implements UserEntityMapper {

    @Override
    public UserResponseDto userEntityToUserResponseDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setName( userEntity.getName() );
        userResponseDto.setLastName( userEntity.getLastName() );
        userResponseDto.setEmail( userEntity.getEmail() );
        userResponseDto.setPassword( userEntity.getPassword() );

        return userResponseDto;
    }

    @Override
    public UserEntity userRequestDtoToUserEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( userRequestDto.getUserId() );
        userEntity.setName( userRequestDto.getName() );

        return userEntity;
    }

    @Override
    public List<UserResponseDto> userEntityListToUserResponseDtoList(Collection<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( userEntityToUserResponseDto( userEntity ) );
        }

        return list;
    }
}
