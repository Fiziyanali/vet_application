package com.vetApplication.beyzaClinic.controller;

import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import com.vetApplication.beyzaClinic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loginPage(UserEntity userEntity) {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(UserEntity userEntity) {
        return "register";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result, RedirectAttributes atts){
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/";
        }
        if(userService.isLogin(userEntity.getUser_name(), userEntity.getPassword())) {
            atts.addFlashAttribute("message", "Başarıyla giriş yaptınız!");
            atts.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/users";
        } else {
            atts.addFlashAttribute("message", "Sistemde böyle biri yok!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request,Authentication authentication, RedirectAttributes atts) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        authentication.setAuthenticated(false);
        atts.addFlashAttribute("message", "Başarıyla çıkış yaptınız!");
        atts.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("userEntity") UserEntity userEntity, BindingResult result, RedirectAttributes atts){
        if (result.hasErrors()) {
            atts.addFlashAttribute("message", "Bilgileri kontrol ediniz!");
            atts.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/register";
        }
        userService.createUser(userEntity);
        atts.addFlashAttribute("message", "Kullanıcı eklendi");
        atts.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/";
    }
}
