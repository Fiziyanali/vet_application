package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model, UserEntity userEntity) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id, RedirectAttributes atts) {
        try {
            atts.addFlashAttribute("message", "Kullanıcı silindi!");
            atts.addFlashAttribute("alertClass", "alert-success");
            userService.deleteUserById(id);
            return "redirect:/users";
        } catch(Exception e){
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/users";
        }
    }


    @PostMapping("/addUser")
    public String createUser(@Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result, RedirectAttributes atts){
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/users";
        }
        userService.createUser(userEntity);
        atts.addFlashAttribute("message", "Kullanıcı eklendi");
        atts.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("userEntity")  UserEntity userEntity, BindingResult result, RedirectAttributes atts, Model model) {
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/users";
        }
        atts.addFlashAttribute("message", "Kullanıcı güncellendi!");
        atts.addFlashAttribute("alertClass", "alert-success");
        userService.updateUserById(userEntity);
        return "redirect:/users";
    }
}
