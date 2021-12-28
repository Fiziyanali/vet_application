package com.vetApplication.beyzaClinic.repository;

import com.vetApplication.beyzaClinic.model.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<OwnerEntity, Long> {

}
