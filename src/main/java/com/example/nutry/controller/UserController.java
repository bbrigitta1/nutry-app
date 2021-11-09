package com.example.nutry.controller;


import com.example.nutry.model.User;
import com.example.nutry.model.UserDetails;
import com.example.nutry.model.UserDetailsDTO;
import com.example.nutry.model.UserRegistrationDTO;
import com.example.nutry.service.UserDetailsService;
import com.example.nutry.service.UserService;
import org.apache.commons.io.IOUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.tools.FileObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.UUID;

@RestController
@CrossOrigin(origins="${crossorigin}")
public class UserController {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    ResourceLoader resourceLoader;

    private UUID uuid;

    private static String imageDirectory = System.getProperty("user.dir") + "/profileimages";

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
        return userDetailsDTO;

        //TODO read from session



    }

    @PostMapping("/addprofilepicture")
    public void uploadPicture(@RequestBody MultipartFile file, Authentication authentication) throws IOException {
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        makeDirectoryIfNotExist(imageDirectory);
        if (user.getProfileImageFilename()!= null) {
            String filenameWithNoExtension = user.getProfileImageFilename().toString().substring(0,user.getProfileImageFilename().toString().lastIndexOf('.'));
            Files.deleteIfExists(Paths.get(imageDirectory,
                    filenameWithNoExtension + ".jpg"));
            Files.deleteIfExists(Paths.get(imageDirectory,
                    filenameWithNoExtension + ".jpeg"));
            Files.deleteIfExists(Paths.get(imageDirectory,
                    filenameWithNoExtension + ".png"));
        }
        UUID fileName = UUID.randomUUID();
        Path fileNamePath = Paths.get(imageDirectory,
                fileName + "." + (FilenameUtils.getExtension(file.getOriginalFilename())));
        Files.write(fileNamePath, file.getBytes());
        user.setProfileImageFilename(fileName + "." + (FilenameUtils.getExtension(file.getOriginalFilename())));
        userService.save(user);
    }


    @PostMapping("/getprofilepicture")
    public String getPicture(@RequestBody String example, Authentication authentication) throws IOException {
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        return user.getProfileImageFilename();
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

};
