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

            Nutrient nutrient2 = Nutrient.builder()
                    .nutrientId2(1003L)
                    .nutrientName("Protein")
                    .unitName("G")
                    .build();

            Nutrient nutrient3 = Nutrient.builder()
                    .nutrientId2(1004L)
                    .nutrientName("Total lipid (fat)")
                    .unitName("G")
                    .build();

            Nutrient nutrient4 = Nutrient.builder()
                    .nutrientId2(1005L)
                    .nutrientName("Carbohydrate, by difference")
                    .unitName("MG")
                    .build();

            nutrientService.save(nutrient1);

            User user = User.builder()
                    .id(1L)
                    .userName("Example User")
                    .build();
            userRepository.save(user);
            nutrientService.save(nutrient2);
            nutrientService.save(nutrient3);
            nutrientService.save(nutrient4);

        };
    };
};

