package com.example.nutry.config;

import com.example.nutry.model.Nutrient;
import com.example.nutry.repository.AddedFoodRepository;
import com.example.nutry.repository.NutrientRepository;
import com.example.nutry.service.NutrientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class NutrientConfig {

    @Autowired
    NutrientService nutrientService;
    @Bean
    CommandLineRunner commandLineRunnerAddFood(NutrientRepository nutrientRepository) {
        return args -> {
            Nutrient nutrient1 = Nutrient.builder()
                    .nutrientName("Calcium, Ca")
                    .unitName("MG")
                    .build();

            nutrientService.save(nutrient1);
        };
    };
};

