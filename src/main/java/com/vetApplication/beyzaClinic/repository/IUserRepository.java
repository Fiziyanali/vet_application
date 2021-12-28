package com.vetApplication.beyzaClinic.repository;

import com.vetApplication.beyzaClinic.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM user where" +
            " user_name=:username", nativeQuery = true)
    UserEntity findByUsername(@Param("username") String username);

   @Query(value = "SELECT * FROM user where" +
            " user_name=:username and password=:password", nativeQuery = true)
    UserEntity login(@Param("username") String username,@Param("password") String password);
}
