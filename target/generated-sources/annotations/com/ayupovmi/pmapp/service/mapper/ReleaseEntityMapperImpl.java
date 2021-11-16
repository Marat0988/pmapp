package com.ayupovmi.pmapp.service.mapper;

import com.ayupovmi.pmapp.entity.ReleaseEntity;
import com.ayupovmi.pmapp.rest.dto.ReleaseRequestDto;
import com.ayupovmi.pmapp.rest.dto.ReleaseResponseDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-17T00:07:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class ReleaseEntityMapperImpl implements ReleaseEntityMapper {

    @Override
    public ReleaseResponseDto releaseEntityToReleaseResponseDto(ReleaseEntity releaseEntity) {
        if ( releaseEntity == null ) {
            return null;
        }

        LocalDateTime endDate = null;
        LocalDateTime startDate = null;

        endDate = releaseEntity.getEndDate();
        startDate = releaseEntity.getStartDate();

        ReleaseResponseDto releaseResponseDto = new ReleaseResponseDto( startDate, endDate );

        return releaseResponseDto;
    }

    @Override
    public ReleaseEntity releaseRequestDtoToReleaseEntity(ReleaseRequestDto releaseRequestDto) {
        if ( releaseRequestDto == null ) {
            return null;
        }

        ReleaseEntity releaseEntity = new ReleaseEntity();

        releaseEntity.setReleaseId( releaseRequestDto.getReleaseId() );

        return releaseEntity;
    }

    @Override
    public List<ReleaseResponseDto> releaseEntityListToReleaseResponseDtoList(Collection<ReleaseEntity> ReleaseEntityList) {
        if ( ReleaseEntityList == null ) {
            return null;
        }

        List<ReleaseResponseDto> list = new ArrayList<ReleaseResponseDto>( ReleaseEntityList.size() );
        for ( ReleaseEntity releaseEntity : ReleaseEntityList ) {
            list.add( releaseEntityToReleaseResponseDto( releaseEntity ) );
        }

        return list;
    }
}
