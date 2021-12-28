package com.vetApplication.beyzaClinic.service;

import com.vetApplication.beyzaClinic.model.entity.PetEntity;

import java.util.List;

public interface ISearchService {

    List<PetEntity> getAllPets();

    List<PetEntity> getByKeyword(String keyword);
}
