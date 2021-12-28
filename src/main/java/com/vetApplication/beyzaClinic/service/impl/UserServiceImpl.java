package com.vetApplication.beyzaClinic.service.impl;

import com.vetApplication.beyzaClinic.exceptions.GeneralException;
import com.vetApplication.beyzaClinic.exceptions.GeneralResult;
import com.vetApplication.beyzaClinic.model.dto.UserDto;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.model.mapper.IUserMapper;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;
import com.vetApplication.beyzaClinic.repository.IUserRepository;
import com.vetApplication.beyzaClinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto getUserById(Long Id) {
        final UserEntity userEntity = userRepository.getById(Id);
        return IUserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Override
    public BaseResponse deleteUserById(Long Id) {
        final UserEntity userEntity = userRepository.getById(Id);
        if (Objects.nonNull(userEntity)){
            userRepository.deleteById(userEntity.getId());
            return BaseResponse.builder()
                    .messageCode("Success!")
                    .messageText("Silme işlemi başarılı!")
                    .build();
        }
        return BaseResponse.builder()
                .messageCode("Error!")
                .messageText("Silinecek kişi bulunamadı!")
                .build();
    }
    @Override
    public UserDto updateUserById(UserEntity userEntity) {

        if (Objects.isNull(userEntity)) {
            throw new GeneralException(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage("Kişi bulunamadı")
                    .build());
        }
        UserEntity userEntity1 = userRepository.findByUsername(userEntity.getUser_name());

        if(userEntity1.getId() == userEntity.getId()){
            userEntity.setPassword(encoder.encode(userEntity.getPassword()));
            userRepository.save(userEntity);
        } else {
            throw new GeneralException(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage("Aynı isimde başka kullanıcı var!")
                    .build());
        }
        return IUserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Override
    public Boolean isLogin(String username, String password) {
        if(encoder.matches(password, userRepository.findByUsername(username).getPassword())) {
            password = userRepository.findByUsername(username).getPassword();
        }
        if(Objects.isNull(userRepository.login(username,password))){
            return false;
        } else{
            return true;
        }
    }


    @Override
    public UserDto createUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return IUserMapper.INSTANCE.toUserDto(userEntity);
    }


}
