package com.vetApplication.beyzaClinic.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name="user")
public class UserEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Kullanıcı adı alanı boş olamaz!")
    @Size(min = 5, max = 15)
    @Column(name="user_name",unique=true)
    private String user_name;

    @NotEmpty(message = "Şifre alanı boş olamaz!")
    @Size(min = 5, max = 60)
    @Column(name="password")
    private String password;
    private String role;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}
