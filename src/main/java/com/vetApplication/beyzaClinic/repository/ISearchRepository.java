package com.vetApplication.beyzaClinic.repository;

import com.vetApplication.beyzaClinic.model.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISearchRepository extends JpaRepository<PetEntity, Long> {

    @Query(value = "SELECT * FROM pet LEFT JOIN owner ON pet.owner_id = owner.id " +
            "where pet.name like %:keyword% or owner.name  like %:keyword% " +
            "order by pet.name", nativeQuery = true)
    List<PetEntity> findByKeyword(@Param("keyword") String keyword);
}
