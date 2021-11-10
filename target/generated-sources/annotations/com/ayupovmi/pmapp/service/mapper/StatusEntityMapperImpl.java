package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.StatusEntity;
import com.ayupovmi.pmapp.rest.dto.StatusReponseDto;
import com.ayupovmi.pmapp.rest.dto.StatusRequestDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T02:11:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class StatusEntityMapperImpl implements StatusEntityMapper {

    @Override
    public StatusReponseDto statusEntityToStatusResponseDto(StatusEntity statusEntity) {
        if ( statusEntity == null ) {
            return null;
        }

        StatusReponseDto statusReponseDto = new StatusReponseDto();

        statusReponseDto.setName( statusEntity.getName() );

        return statusReponseDto;
    }

    @Override
    public StatusEntity statusRequestDtoToStatusEntity(StatusRequestDto statusRequestDto) {
        if ( statusRequestDto == null ) {
            return null;
        }

        StatusEntity statusEntity = new StatusEntity();

        statusEntity.setStatusId( statusRequestDto.getStatusId() );
        statusEntity.setName( statusRequestDto.getName() );

        return statusEntity;
    }

    @Override
    public List<StatusReponseDto> statusEntityListToStatusResponseDtoList(Collection<StatusEntity> statusEntityList) {
        if ( statusEntityList == null ) {
            return null;
        }

        List<StatusReponseDto> list = new ArrayList<StatusReponseDto>( statusEntityList.size() );
        for ( StatusEntity statusEntity : statusEntityList ) {
            list.add( statusEntityToStatusResponseDto( statusEntity ) );
        }

        return list;
    }
}
