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
    public void save(UserDetails userDetails){userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails findByDateAndUser(LocalDate date, User user){
        return userDetailsRepository.findByDateAndUser(date,user);
    }

    @Override
    public UserDetails findLatestByDateAndUser(LocalDate date, User user) {
        date = date.plusDays(1);
        List<UserDetails> userDetailsList = userDetailsRepository.findAllByDateLessThanEqualAndUser(date, user);
        if (userDetailsList.size() == 0) {
            return null;
        }
        return userDetailsList.get(userDetailsList.size()-1);
    }
}
