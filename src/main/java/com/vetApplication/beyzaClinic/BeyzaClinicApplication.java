package com.vetApplication.beyzaClinic;

import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class BeyzaClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeyzaClinicApplication.class, args);
	}

	@RequestMapping("/")
	public String index(UserEntity userEntity) {
		return "login";
	}
}
