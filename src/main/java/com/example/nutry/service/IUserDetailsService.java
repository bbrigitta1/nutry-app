package com.example.nutry.service;

import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;

import java.time.LocalDate;
import java.util.List;

public interface IUserDetailsService {
    void save(UserDetails userDetails);
    UserDetails findByDateAndUser(LocalDate date, User user);
    UserDetails findLatestByDateAndUser(LocalDate date, User user);

}
