package com.example.nutry.config;

import com.example.nutry.repository.AddedFoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddedFoodConfig {
    @Bean
    CommandLineRunner commandLineRunnerAddFood(AddedFoodRepository addedFoodRepository) {
        return args -> {
//            Food food1 = new Food("Apple");
//            Food food2 = new Food("Pear");
//            foodRepository.saveAll(List.of(food1, food2));
        };
    }
}
