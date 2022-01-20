package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.OwnerDto;
import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:16:41+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class IOwnerMapperImpl implements IOwnerMapper {

    @Override
    public OwnerDto toOwnerDto(OwnerEntity source) {
        if ( source == null ) {
            return null;
        }

        OwnerDto ownerDto = new OwnerDto();

        return ownerDto;
    }

    @Override
    public OwnerEntity toOwnerEntity(OwnerDto source) {
        if ( source == null ) {
            return null;
        }

        OwnerEntity ownerEntity = new OwnerEntity();

        return ownerEntity;
    }

    @Override
    public List<OwnerDto> toOwnerDtoList(List<OwnerEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnerDto> list1 = new ArrayList<OwnerDto>( list.size() );
        for ( OwnerEntity ownerEntity : list ) {
            list1.add( toOwnerDto( ownerEntity ) );
        }

        return list1;
    }

    @Override
    public List<OwnerEntity> toOwnerEntityList(List<OwnerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnerEntity> list1 = new ArrayList<OwnerEntity>( list.size() );
        for ( OwnerDto ownerDto : list ) {
            list1.add( toOwnerEntity( ownerDto ) );
        }

        return list1;
    }
}
