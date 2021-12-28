package com.vetApplication.beyzaClinic.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerDto {

    private long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
}
