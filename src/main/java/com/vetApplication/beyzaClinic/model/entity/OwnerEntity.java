package com.vetApplication.beyzaClinic.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name="owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Ad alanı boş olamaz!")
    @Size(min = 3, max = 15)
    private String name;

    @NotEmpty(message = "Soyad alanı boş olamaz!")
    @Size(min = 2, max = 15)
    private String surname;

    @Size(min = 5, max = 150)
    private String address;

    private String phone;
    private String email;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
    private Set<PetEntity> petEntitySet = new HashSet<>();
}
