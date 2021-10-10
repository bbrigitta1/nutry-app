package com.example.nutry.service;

import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;

import java.time.LocalDate;

public interface IUserDetailsService {
    UserDetails findByDateAndUser(LocalDate date, User user);

}
