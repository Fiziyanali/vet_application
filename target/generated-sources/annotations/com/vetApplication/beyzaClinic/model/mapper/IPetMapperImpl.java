package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.PetDto;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:16:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class IPetMapperImpl implements IPetMapper {

    @Override
    public PetDto toPetDto(PetEntity source) {
        if ( source == null ) {
            return null;
        }

        PetDto petDto = new PetDto();

        return petDto;
    }

    @Override
    public PetEntity toPetEntity(PetDto source) {
        if ( source == null ) {
            return null;
        }

        PetEntity petEntity = new PetEntity();

        return petEntity;
    }

    @Override
    public List<PetDto> toPetDtoList(List<PetEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PetDto> list1 = new ArrayList<PetDto>( list.size() );
        for ( PetEntity petEntity : list ) {
            list1.add( toPetDto( petEntity ) );
        }

        return list1;
    }

    @Override
    public List<PetEntity> toPetEntityList(List<PetDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PetEntity> list1 = new ArrayList<PetEntity>( list.size() );
        for ( PetDto petDto : list ) {
            list1.add( toPetEntity( petDto ) );
        }

        return list1;
    }
}
