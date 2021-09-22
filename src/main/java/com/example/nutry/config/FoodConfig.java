package com.example.nutry.config;

import com.example.nutry.model.Food;
import com.example.nutry.repository.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FoodConfig {
    @Bean
    CommandLineRunner commandLineRunner (FoodRepository foodRepository) {
        return args -> {
            Food food1 = new Food("Apple");
            Food food2 = new Food("Pear");
            foodRepository.saveAll(List.of(food1, food2));
        };
    }
}
