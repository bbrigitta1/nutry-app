package com.example.nutry.repository;

import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserDetailsRepository extends JpaRepository <UserDetails, Long> {

    UserDetails findByDateAndUser(LocalDate localDate, User user);

}
