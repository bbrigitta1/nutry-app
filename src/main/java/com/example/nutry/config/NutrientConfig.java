package com.example.nutry.config;

import com.example.nutry.model.Nutrient;
import com.example.nutry.model.User;
import com.example.nutry.repository.AddedFoodRepository;
import com.example.nutry.repository.NutrientRepository;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NutrientConfig {

    @Autowired
    NutrientService nutrientService;

    @Autowired
    UserRepository userRepository;
    @Bean
    CommandLineRunner commandLineRunnerAddNutrient() {
        return args -> {
            Nutrient nutrient1 = Nutrient.builder()
                    .nutrientId2(1087L)
                    .nutrientName("Calcium, Ca")
                    .unitName("MG")
                    .build();

            nutrientService.save(nutrient1);

            User user = User.builder()
                    .id(1L)
                    .userName("Example User")
                    .build();
            userRepository.save(user);
        };
    };
};

