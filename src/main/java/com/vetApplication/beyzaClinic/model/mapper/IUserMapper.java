package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.UserDto;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserDto toUserDto(UserEntity source);

    UserEntity toUserEntity(UserDto source);

    List<UserDto> toUserDtoList(List<UserEntity> list);

    List<UserEntity> toUserEntityList(List<UserDto> list);

}
