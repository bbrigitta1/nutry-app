package com.example.nutry.controller;


import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import com.example.nutry.model.UserRegistrationDTO;
import com.example.nutry.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addusertobatabse")
    public void saveUser(@RequestBody UserRegistrationDTO userDTO){

        User user = User.builder()
                .userName(userDTO.getUserName())
                .build();

        UserDetails userDetails = UserDetails.builder()
                .weight(userDTO.getWeight())
                .activity(userDTO.getActivity())
                .age(userDTO.getAge())
                .gender(userDTO.getGender())
                .goal(userDTO.getGoal())
                .height(userDTO.getHeight())
                .date(LocalDate.now())
                .user(user)
                .build();

        user.setUserDetails(Lists.newArrayList(userDetails));

//        System.out.println(user);
        userService.save(user);
    };

};
