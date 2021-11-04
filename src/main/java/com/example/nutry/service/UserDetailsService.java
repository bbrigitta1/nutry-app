package com.example.nutry.service;

import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import com.example.nutry.repository.UserDetailsRepository;
import com.example.nutry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserDetailsService implements IUserDetailsService{


    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails findByDateAndUser(LocalDate date, User user){
        return userDetailsRepository.findByDateAndUser(date,user);
    }

    @Override
    public UserDetails findLatestByDateAndUser(LocalDate date, User user) {
        List<UserDetails> userDetailsList = userDetailsRepository.findAllByDateLessThanEqualAndUser(date, user);
        //System.out.println(userDetailsList);
        if (userDetailsList.size() == 0) {
            return null;
        }
        return userDetailsList.get(0);
    }
}
