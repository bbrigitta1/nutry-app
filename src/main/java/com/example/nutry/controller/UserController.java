package com.example.nutry.controller;


import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import com.example.nutry.model.UserDetailsDTO;
import com.example.nutry.model.UserRegistrationDTO;
import com.example.nutry.service.UserDetailsService;
import com.example.nutry.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/addusertodatabase")
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

    @GetMapping("/getuserdata")
    public UserDetailsDTO getUserData(){

        //TODO get userID from session
        User user = userService.findById(1L);

        UserDetails userDetails = userDetailsService.findByDateAndUser(LocalDate.now(),user);


        UserDetailsDTO userDetailsDTO= new UserDetailsDTO();
        userDetailsDTO.setUserName(user.getUserName());
        Integer recommended =  (int)((10 * userDetails.getWeight()
                + 6.25 * userDetails.getHeight()
                - 5 * userDetails.getAge()
                + userDetails.getGender()) * userDetails.getActivity() * userDetails.getGoal());

        userDetailsDTO.setRecommended(recommended);
        System.out.println(userDetailsDTO);
        return userDetailsDTO;

        //TODO read from session



    }

};
