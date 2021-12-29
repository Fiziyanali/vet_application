package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultPage(UserEntity userEntity) {
        return "login";
    }

}
