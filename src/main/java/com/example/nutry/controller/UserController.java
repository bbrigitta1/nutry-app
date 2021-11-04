package com.example.nutry.controller;


import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import com.example.nutry.model.UserDetailsDTO;
import com.example.nutry.model.UserRegistrationDTO;
import com.example.nutry.service.UserDetailsService;
import com.example.nutry.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    private static String imageDirectory = System.getProperty("user.dir") + "/images/";

    @PostMapping("/addusertodatabase")
    public void saveUser(@RequestBody UserRegistrationDTO userDTO){

        User user = User.builder()
                .userName(userDTO.getUserName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .build();

        UserDetails userDetails = UserDetails.builder()
                .weight(userDTO.getWeight())
                .activity(userDTO.getActivity())
                .birthdate(userDTO.getBirthdate())
                .age(Period.between(userDTO.getBirthdate(), LocalDate.now()).getYears())
                .gender(userDTO.getGender())
                .goal(userDTO.getGoal())
                .height(userDTO.getHeight())
                .date(LocalDate.now())
                .user(user)
                .build();

        user.setUserDetails(Lists.newArrayList(userDetails));

        System.out.println(user);
        userService.save(user);
    };

    @GetMapping("/getuserdata")
    public UserDetailsDTO getUserData(){

        //TODO get userID from session
        User user = userService.findById(1L);

        UserDetails userDetails = userDetailsService.findLatestByDateAndUser(LocalDate.now(),user);


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

    @PostMapping("/addprofilepicture")
    public ResponseEntity<String> uploadPicture(@RequestBody MultipartFile file){
        String name = "";
        System.out.println("hey");
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory,
                name.concat(".").concat(FilenameUtils.getExtension(file.getOriginalFilename())));
        try {
            Files.write(fileNamePath, file.getBytes());
            return new ResponseEntity<>(name, HttpStatus.CREATED);
        } catch (IOException ex) {
            return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
        }
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

};
