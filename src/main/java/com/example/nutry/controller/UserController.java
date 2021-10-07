package com.example.nutry.controller;


import com.example.nutry.model.User;
import com.example.nutry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addusertobatabse")
    public void saveUser(@RequestBody User user){
        User userData = User.builder()
                .userName(user.getUserName())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getHeight())
                .gender(user.getGender())
                .activity(user.getActivity())
                .goal(user.getGoal())
                .build();

        System.out.println(user);
        userService.save(userData);
    };

};
