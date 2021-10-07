package com.example.nutry.controller;

import com.example.nutry.model.Food;
import com.example.nutry.model.FoodConsumed;
import com.example.nutry.model.FoodNutrient;
import com.example.nutry.model.User;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.FoodConsumedService;
import com.example.nutry.service.NutrientService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AddedFoodController {



    @Autowired
    private AddedFoodService addedFoodService;

    @Autowired
    private FoodConsumedService foodConsumedService;

    @Autowired
    NutrientService  nutrientService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/getallfoodsfortheday")
    public List<Food> getAllFoodsForTheDay() {

        //TODO get user ID from session
        User exampleUser = userRepository.findAll().get(0);

        List<Food> foodsToDisplay = new ArrayList<>();
        List<FoodConsumed> consumedFoods = foodConsumedService.findByUser(exampleUser);
        for (FoodConsumed consumedFood: consumedFoods){
            FoodConsumed foodConsumed = FoodConsumed.builder()
                    .amount(consumedFood.getAmount()).build();
            Food food = Food.builder()
                    .id(consumedFood.getId())
                    .description(consumedFood.getFood().getDescription())
                    .energy(consumedFood.getFood().getEnergy())
                    .foodConsumed(Lists.newArrayList(foodConsumed))
                    .build();
            foodsToDisplay.add(food);
        }
        System.out.println(foodsToDisplay);
        return foodsToDisplay;
    }

    @PostMapping("/addfoodtomealplan")
    public void saveFood(@RequestBody Food food){

        //TODO get user ID from session
        User exampleUser = userRepository.findAll().get(0);

        FoodConsumed foodConsumed = FoodConsumed.builder()
                .amount(100)
                .consumptionDate(LocalDate.of(2021,9,1))
                .user(exampleUser)
                .build();
        exampleUser.setFoodConsumeds(Lists.newArrayList(foodConsumed));

        Food foodNew = Food.builder()
                .description(food.getDescription())
                .fdcId(food.getFdcId())
                .energy(food.getEnergy())
                .foodNutrients(food.getFoodNutrients())
                .foodConsumed(Lists.newArrayList(foodConsumed))
                .build();
        foodConsumed.setFood(foodNew);

        foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew)));
        foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));

        addedFoodService.save(foodNew);
//        try {
//            addedFoodService.save(foodNew);
//        } catch(DataIntegrityViolationException e) {
//            foodConsumedService.save(food.getFoodConsumed().get(0));
//            System.out.println("Entity already exists. Skipping ...");
//        }


    }

}
