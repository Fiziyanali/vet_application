package com.vetApplication.beyzaClinic.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@Table(name="pet")
public class PetEntity {

    public PetEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Ad alanı boş olamaz!")
    @Size(min = 3, max = 15)
    private String name;

    @Size(max = 15)
    private String genus;

    @Size(max = 15)
    private String type;

    @Size(max = 150)
    private String explanation;

    private float age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OwnerEntity owner_id;
}
