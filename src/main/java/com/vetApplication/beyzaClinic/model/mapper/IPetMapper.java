package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.PetDto;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IPetMapper {

    IPetMapper INSTANCE = Mappers.getMapper(IPetMapper.class);

    PetDto toPetDto(PetEntity source);

    PetEntity toPetEntity(PetDto source);

    List<PetDto> toPetDtoList(List<PetEntity> list);

    List<PetEntity> toPetEntityList(List<PetDto> list);

}
