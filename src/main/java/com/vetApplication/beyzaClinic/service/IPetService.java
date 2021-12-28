package com.vetApplication.beyzaClinic.service;

import com.vetApplication.beyzaClinic.model.dto.PetDto;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;

import java.util.List;

public interface IPetService {
    List<PetEntity> getAllPets();

    PetDto getPetById(Long Id);

    BaseResponse deletePetById(Long Id);

    PetDto createPet(PetEntity petEntity);

    PetDto updatePetById(PetEntity petEntity);

}
