package com.example.nutry.config;

import com.example.nutry.model.*;
import com.example.nutry.repository.AddedFoodRepository;
import com.example.nutry.repository.NutrientRepository;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.NutrientService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class NutrientConfig {

    @Autowired
    NutrientService nutrientService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddedFoodService addedFoodService;

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

            User user = User.builder()
                    .id(1L)
                    .userName("Example User")
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .height(180)
                    .weight(80)
                    .activity(1.1)
                    .gender(0.0)
                    .age(30)
                    .goal(1.0)
                    .build();

            userRepository.save(user);

            nutrientService.save(nutrient1);
            nutrientService.save(nutrient2);
            nutrientService.save(nutrient3);
            nutrientService.save(nutrient4);


            User exampleUser = userRepository.findAll().get(0);
            userDetails.setUser(exampleUser);

            exampleUser.setUserDetails(Lists.newArrayList(userDetails));

            userRepository.save(exampleUser);

            FoodConsumed foodConsumed = FoodConsumed.builder()
                    .amount(100)
                    .consumptionDate(LocalDate.of(2021, 9, 1))
                    .user(exampleUser)
                    .build();

            FoodConsumed foodConsumed2 = FoodConsumed.builder()
                    .amount(100)
                    .consumptionDate(LocalDate.of(2021, 9, 1))
                    .user(exampleUser)
                    .build();
            exampleUser.setFoodConsumeds(Lists.newArrayList(foodConsumed, foodConsumed2));

            Food foodNew = Food.builder()
                    .description("Apple")
                    .fdcId(1555L)
                    .energy(45)
//                    .foodNutrients(food.getFoodNutrients())
                    .foodConsumed(Lists.newArrayList(foodConsumed))
                    .build();
            foodConsumed.setFood(foodNew);

            Food foodNew2 = Food.builder()
                    .description("Ham")
                    .fdcId(1669L)
                    .energy(45)
//                    .foodNutrients(food.getFoodNutrients())
                    .foodConsumed(Lists.newArrayList(foodConsumed2))
                    .build();
            foodConsumed2.setFood(foodNew2);



            FoodNutrient protein = FoodNutrient.builder()
                    .nutrientId2(1003L)
                    .value(13.8)
                    .food(foodNew)
                    .nutrient(nutrient2)
                    .build();

            FoodNutrient fat = FoodNutrient.builder()
                    .nutrientId2(1004L)
                    .value(20.5)
                    .food(foodNew)
                    .nutrient(nutrient3)
                    .build();

            FoodNutrient carbohydrate = FoodNutrient.builder()
                    .nutrientId2(1005L)
                    .value(50.8)
                    .food(foodNew)
                    .nutrient(nutrient4)
                    .build();

            FoodNutrient protein2 = FoodNutrient.builder()
                    .nutrientId2(1003L)
                    .value(13.8)
                    .food(foodNew2)
                    .nutrient(nutrient2)
                    .build();

            FoodNutrient fat2 = FoodNutrient.builder()
                    .nutrientId2(1004L)
                    .value(20.5)
                    .food(foodNew2)
                    .nutrient(nutrient3)
                    .build();

            FoodNutrient carbohydrate2 = FoodNutrient.builder()
                    .nutrientId2(1005L)
                    .value(50.8)
                    .food(foodNew2)
                    .nutrient(nutrient4)
                    .build();


            foodNew.setFoodNutrients(List.of(protein, fat, carbohydrate));
            foodNew2.setFoodNutrients(List.of(protein2, fat2, carbohydrate2));

            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew)));
            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew2)));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));

            addedFoodService.save(foodNew);
            addedFoodService.save(foodNew2);

        };
    }
};

