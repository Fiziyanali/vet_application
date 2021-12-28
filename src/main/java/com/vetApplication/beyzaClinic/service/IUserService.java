package com.vetApplication.beyzaClinic.service;

import com.vetApplication.beyzaClinic.model.dto.UserDto;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAllUsers();

    UserDto getUserById(Long Id);

    BaseResponse deleteUserById(Long Id);

    UserDto createUser(UserEntity userEntity);

    UserDto updateUserById(UserEntity userEntity);

    Boolean isLogin(String username, String password);

}
