package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.FoodConsumedService;
import com.example.nutry.service.NutrientService;
import com.example.nutry.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    UserService userService;


    @GetMapping("/updatemealplan")
    public MealPlanDTO getAllFoodsForTheDay() {

        //TODO get user ID from session
        User exampleUser = userRepository.findAll().get(0);
        List<Food> foodsToDisplay = new ArrayList<>();
        List<FoodConsumed> consumedFoodsByUser = foodConsumedService.findByUser(exampleUser);
        for (FoodConsumed consumedFoodByUser: consumedFoodsByUser){
            FoodConsumed foodConsumed = FoodConsumed.builder()
                    .id(consumedFoodByUser.getId())
                    .amount(consumedFoodByUser.getAmount()).build();
            Food food = Food.builder()
                    .description(consumedFoodByUser.getFood().getDescription())
                    .energy(consumedFoodByUser.getFood().getEnergy())
                    .foodConsumed(Lists.newArrayList(foodConsumed))
                    .build();
            foodsToDisplay.add(food);
        }

        MealPlanDTO mealPlan= new MealPlanDTO();
        mealPlan.setFoods(foodsToDisplay);
        mealPlan.setMacroNutrients(getMacroNutrients());
        System.out.println("mealplan " + mealPlan);
        return mealPlan;
    }

    @PostMapping("/addfoodtomealplan")
    public void saveFood(@RequestBody Food food){

        //TODO get user ID from session
        User exampleUser = userRepository.findAll().get(0);
        FoodConsumed foodConsumed = FoodConsumed.builder()
                .amount(100)
                .consumptionDate(LocalDate.of(2021, 9, 1))
                .user(exampleUser)
                .build();
        exampleUser.setFoodConsumeds(Lists.newArrayList(foodConsumed));

        if (addedFoodService.findByFcdId(food.getFdcId()) == null) {
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
        } else {
            Food foodAlreadyInDatabase = addedFoodService.findByFcdId(food.getFdcId());
            foodConsumed.setFood(foodAlreadyInDatabase);
            foodConsumedService.save(foodConsumed);
            }
        }

    @PostMapping("/changeamountoffood")
    public void changeAmountOfFood(@RequestBody AmountChangeDTO amountChangeDTO) {
        Long consumedFoodId = amountChangeDTO.getConsumedFoodId();
        String direction = amountChangeDTO.getDirection();
        Integer amount = Objects.equals(direction, "+")
                    ? 25
                    : -25;
        foodConsumedService.changeFoodAmount(consumedFoodId, amount);
    }

    @PostMapping("/deletefood")
    public void deleteFood(@RequestBody AmountChangeDTO amountChangeDTO){
        Long consumedFoodId = amountChangeDTO.getConsumedFoodId();
        foodConsumedService.deleteFood(consumedFoodId);
    }

    @PostMapping("/changeamountoffoodtocustomvalue")
    public void changeAmountOfFoodByCustomValue(@RequestBody AmountChangeDTO amountChangeDTO){
        Long consumedFoodId = amountChangeDTO.getConsumedFoodId();
        foodConsumedService.changeFoodAmountByCustomValue(consumedFoodId,amountChangeDTO.getAmount());
    }

    private MacroNutrientsDTO getMacroNutrients() {
        HashMap<String, Integer> nutrients = new HashMap<>();
        User user = userService.findById(1L);
        List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, LocalDate.of(2021, 9, 1));
        Double sumOfProteins = 0.0;
        Double sumOfFat = 0.0;
        Double sumOfCarbohydrate = 0.0;
        for (FoodConsumed foodConsumedByUser : foodsConsumedByUser) {
            for (FoodNutrient foodNutrient : foodConsumedByUser.getFood().getFoodNutrients()) {
                if (foodNutrient.getNutrientId2().equals(1003L)) {
                    sumOfProteins += foodNutrient.getValue() * foodConsumedByUser.getAmount() / 100;
                }
                if (foodNutrient.getNutrientId2().equals(1004L)) {
                    sumOfFat += foodNutrient.getValue() * foodConsumedByUser.getAmount() / 100 ;
                }
                if (foodNutrient.getNutrientId2().equals(1005L)) {
                    sumOfCarbohydrate += foodNutrient.getValue() * foodConsumedByUser.getAmount() / 100;
                }
            }
        }

        System.out.println(sumOfProteins);

        MacroNutrientsDTO mn = MacroNutrientsDTO.builder()
                .protein(sumOfProteins)
                .fat(sumOfFat)
                .carbohydrate(sumOfCarbohydrate)
                .build();
        return mn;
    }



}
