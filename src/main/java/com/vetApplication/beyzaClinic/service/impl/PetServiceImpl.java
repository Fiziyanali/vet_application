package com.vetApplication.beyzaClinic.service.impl;

import com.vetApplication.beyzaClinic.exceptions.GeneralException;
import com.vetApplication.beyzaClinic.exceptions.GeneralResult;
import com.vetApplication.beyzaClinic.model.dto.PetDto;
import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import com.vetApplication.beyzaClinic.model.mapper.IPetMapper;
import com.vetApplication.beyzaClinic.model.response.BaseResponse;
import com.vetApplication.beyzaClinic.repository.IPetRepository;
import com.vetApplication.beyzaClinic.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PetServiceImpl implements IPetService {

    @Autowired
    private IPetRepository petRepository;


    @Override
    public List<PetEntity> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public PetDto getPetById(Long Id) {
        final PetEntity petEntity = petRepository.getById(Id);
        return IPetMapper.INSTANCE.toPetDto(petEntity);
    }

    @Override
    public BaseResponse deletePetById(Long Id) {
        final PetEntity petEntity = petRepository.getById(Id);
        if (Objects.nonNull(petEntity)){
            petRepository.deleteById(petEntity.getId());
            return BaseResponse.builder()
                    .messageCode("Success!")
                    .messageText("Silme işlemi başarılı!")
                    .build();
        }
        return BaseResponse.builder()
                .messageCode("Error!")
                .messageText("Silinecek hayvan bulunamadı!")
                .build();
    }
    @Override
    public PetDto updatePetById(PetEntity petEntity) {
        if (Objects.isNull(petEntity)) {
            throw new GeneralException(GeneralResult.builder()
                    .errorCode("Hata!")
                    .errorMessage("Hayvan bulunamadı")
                    .build());
        }

        petRepository.save(petEntity);
        return IPetMapper.INSTANCE.toPetDto(petEntity);
    }
    @Override
    public PetDto createPet(PetEntity petEntity) {
        petRepository.save(petEntity);
        return IPetMapper.INSTANCE.toPetDto(petEntity);
    }


}
