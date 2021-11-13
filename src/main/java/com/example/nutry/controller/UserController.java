package com.example.nutry.controller;


import com.example.nutry.model.*;
import com.example.nutry.service.UserDetailsService;
import com.example.nutry.service.UserService;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.parser.Authorization;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
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

    private static String imageDirectory = "/app/src/main/resources/static/profileimages";

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
    public UserDetailsDTO getUserData(Authentication authentication){
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
//        User user = userService.findById(1L);
        System.out.println(user.getUserName());

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

    @GetMapping("/getuserprofiledetails")
    public UserProfileDetailsDTO getUserProfileDetails(Authentication authentication) throws IOException {
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        UserDetails userDetails = userDetailsService.findLatestByDateAndUser(LocalDate.now(),user);

        UserProfileDetailsDTO userProfileDetailsDTO = new UserProfileDetailsDTO();

        userProfileDetailsDTO.setUserName(user.getUserName());
        userProfileDetailsDTO.setHeight(userDetails.getHeight());
        userProfileDetailsDTO.setWeight(userDetails.getWeight());
        userProfileDetailsDTO.setGender(userDetails.getGender());
        userProfileDetailsDTO.setGoal(userDetails.getGoal());
        userProfileDetailsDTO.setActivity(userDetails.getActivity());
        userProfileDetailsDTO.setBirthdate(userDetails.getBirthdate());
        String genderNum = String.valueOf(userDetails.getGender());
        String activityNum = String.valueOf(userDetails.getActivity());
        String goalNum = String.valueOf(userDetails.getGoal());

        String gender;
        String activity;
        String goal;

        switch (genderNum){
            case "0":
                gender = "Male";
                break;
            case "166":
                gender = "Female";
                break;
            default:
                gender = "Other";
        }
        userProfileDetailsDTO.setGenderinit(gender);

        switch (activityNum){
            case "1.1":
                activity = "Very Light";
                break;
            case "1.6":
                activity = "Moderate";
                break;
            case "1.9":
                activity = "Heavy";
                break;
            default:
                activity = "Light";
        }
        userProfileDetailsDTO.setActivityinit(activity);

        switch (goalNum){
            case "1.2":
                goal = "Gain Muscle";
                break;
            case "0.8":
                goal = "Fat Loss";
                break;
            default:
                goal = "Maintenance";
        }
        userProfileDetailsDTO.setGoalinit(goal);

        System.out.println("getuserprofiledetails " + userProfileDetailsDTO);

        return userProfileDetailsDTO;
    };

    @PostMapping("/updateuserprofiledetails")
    public void updateProfileDetails(@RequestBody UserProfileDetailsDTO userProfileDetailsDTO, Authentication authentication){
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        System.out.println(userProfileDetailsDTO);

        UserDetails userDetails = UserDetails.builder()
                .weight(userProfileDetailsDTO.getWeight())
                .activity(userProfileDetailsDTO.getActivity())
                .birthdate(userProfileDetailsDTO.getBirthdate())
                .age(Period.between(userProfileDetailsDTO.getBirthdate(), LocalDate.now()).getYears())
                .gender(userProfileDetailsDTO.getGender())
                .goal(userProfileDetailsDTO.getGoal())
                .height(userProfileDetailsDTO.getHeight())
                .date(LocalDate.now())
                .user(user)
                .build();

        userDetailsService.save(userDetails);

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
