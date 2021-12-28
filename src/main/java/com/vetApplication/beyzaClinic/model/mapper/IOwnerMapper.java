package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.OwnerDto;
import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IOwnerMapper {

    IOwnerMapper INSTANCE = Mappers.getMapper(IOwnerMapper.class);

    OwnerDto toOwnerDto(OwnerEntity source);

    OwnerEntity toOwnerEntity(OwnerDto source);

    List<OwnerDto> toOwnerDtoList(List<OwnerEntity> list);

    List<OwnerEntity> toOwnerEntityList(List<OwnerDto> list);

}
