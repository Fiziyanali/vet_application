package com.vetApplication.beyzaClinic.repository;

import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<PetEntity, Long> {

}
