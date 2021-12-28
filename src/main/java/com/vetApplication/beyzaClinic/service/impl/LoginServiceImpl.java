package com.vetApplication.beyzaClinic.service.impl;

import com.vetApplication.beyzaClinic.component.CustomUserDetails;
import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(user_name);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı");
        }
        return new CustomUserDetails(user);
    }
}
