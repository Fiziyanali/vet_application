package com.vetApplication.beyzaClinic.service.impl;

import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import com.vetApplication.beyzaClinic.repository.ISearchRepository;
import com.vetApplication.beyzaClinic.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ISearchRepository searchRepository;

    @Override
    public List<PetEntity> getAllPets() {
        List<PetEntity> list =  searchRepository.findAll();
        return list;
    }

    @Override
    public List<PetEntity> getByKeyword(String keyword) {
        return searchRepository.findByKeyword(keyword);
    }
}
