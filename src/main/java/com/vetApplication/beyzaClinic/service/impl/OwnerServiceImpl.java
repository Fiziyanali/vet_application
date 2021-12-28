package com.vetApplication.beyzaClinic.service.impl;

import com.vetApplication.beyzaClinic.exceptions.GeneralException;
import com.vetApplication.beyzaClinic.exceptions.GeneralResult;
import com.vetApplication.beyzaClinic.model.dto.OwnerDto;
import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import com.vetApplication.beyzaClinic.model.mapper.IOwnerMapper;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;
import com.vetApplication.beyzaClinic.repository.IOwnerRepository;
import com.vetApplication.beyzaClinic.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private IOwnerRepository ownerRepository;


    @Override
    public List<OwnerEntity> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public OwnerDto getOwnerById(Long Id) {
        final OwnerEntity ownerEntity = ownerRepository.getById(Id);
        return IOwnerMapper.INSTANCE.toOwnerDto(ownerEntity);
    }

    @Override
    public BaseResponse deleteOwnerById(Long Id) {
        final OwnerEntity ownerEntity = ownerRepository.getById(Id);
        if (Objects.nonNull(ownerEntity)){
            ownerRepository.deleteById(ownerEntity.getId());
            return BaseResponse.builder()
                    .messageCode("Success!")
                    .messageText("Silme işlemi başarılı!")
                    .build();
        }
        return BaseResponse.builder()
                .messageCode("Error!")
                .messageText("Silinecek kişi bulunamadı!")
                .build();
    }
    @Override
    public OwnerDto updateOwnerById(OwnerEntity ownerEntity) {
        if (Objects.isNull(ownerEntity)) {
            throw new GeneralException(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage("Kişi bulunamadı")
                    .build());
        }

        ownerRepository.save(ownerEntity);
        return IOwnerMapper.INSTANCE.toOwnerDto(ownerEntity);
    }
    @Override
    public OwnerDto createOwner(OwnerEntity ownerEntity) {
        ownerRepository.save(ownerEntity);
        return IOwnerMapper.INSTANCE.toOwnerDto(ownerEntity);
    }


}
