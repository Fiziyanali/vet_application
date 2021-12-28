package com.vetApplication.beyzaClinic.service;

import com.vetApplication.beyzaClinic.model.dto.OwnerDto;
import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;

import java.util.List;

public interface IOwnerService {
    List<OwnerEntity> getAllOwners();

    OwnerDto getOwnerById(Long Id);

    BaseResponse deleteOwnerById(Long Id);

    OwnerDto createOwner(OwnerEntity ownerEntity);

    OwnerDto updateOwnerById(OwnerEntity ownerEntity);

}
