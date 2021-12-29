package com.vetApplication.beyzaClinic.model.mapper;

import com.vetApplication.beyzaClinic.model.dto.UserDto;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-29T16:33:26+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserDto toUserDto(UserEntity source) {
        if ( source == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        return userDto;
    }

    @Override
    public UserEntity toUserEntity(UserDto source) {
        if ( source == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    @Override
    public List<UserDto> toUserDtoList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDto> list1 = new ArrayList<UserDto>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( toUserDto( userEntity ) );
        }

        return list1;
    }

    @Override
    public List<UserEntity> toUserEntityList(List<UserDto> list) {
        if ( list == null ) {
            return null;
        }

        List<UserEntity> list1 = new ArrayList<UserEntity>( list.size() );
        for ( UserDto userDto : list ) {
            list1.add( toUserEntity( userDto ) );
        }

        return list1;
    }
}
