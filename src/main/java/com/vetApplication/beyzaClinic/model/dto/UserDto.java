package com.vetApplication.beyzaClinic.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private long id;
    private String user_name;
    private String password;
    private String role;

}
