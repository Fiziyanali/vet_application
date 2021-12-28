package com.vetApplication.beyzaClinic.model.dto;

import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PetDto {

    private long id;
    private String name;
    private String genus;
    private String type;
    private String explanation;
    private float age;
    private long owner_id;
}
