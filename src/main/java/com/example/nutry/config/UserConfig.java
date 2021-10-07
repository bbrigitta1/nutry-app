package com.example.nutry.config;


import com.example.nutry.model.Nutrient;
import com.example.nutry.model.User;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    UserService userService;
    @Bean
    CommandLineRunner  commandLineRunnerAddUser(UserRepository userRepository) {
        return args -> {

        };
    };
}
