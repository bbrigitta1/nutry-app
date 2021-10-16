package com.example.nutry.service;

import com.example.nutry.model.User;
import com.example.nutry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findUserById(userId);
    }

    public User findUserByUserName(String username){
        return userRepository.findUserByUserName(username);
    }

}
