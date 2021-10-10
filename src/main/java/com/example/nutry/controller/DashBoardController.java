package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.service.DashBoardService;
import com.example.nutry.service.FoodConsumedService;
import com.example.nutry.service.IFoodConsumedService;
import com.example.nutry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DashBoardController {

    //DTO -> MacroNutrents.class

    @Autowired
    private FoodConsumedService foodConsumedService;


    @Autowired
    private DashBoardService dashBoardService;

    @Autowired
    private UserService userService;

//    @GetMapping("/getMacroNutrients")
////    private MacroNutrientsDTO getMacroNutrients() {
////        HashMap<String, Integer> nutrients = new HashMap<>();
////        User user = userService.findById(1L);
////        List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, LocalDate.of(2021,9,1));
////        Double sumOfProteins = 0.0;
////        Double sumOfFat = 0.0;
////        Double sumOfCarbohydrate = 0.0;
////        for (FoodConsumed foodConsumedByUser: foodsConsumedByUser){
////            for (FoodNutrient foodNutrient: foodConsumedByUser.getFood().getFoodNutrients()){
////                if (foodNutrient.getNutrientId2().equals(1003L)){
////                    sumOfProteins += foodNutrient.getValue() * 100 / foodConsumedByUser.getAmount();
////                }
////                if (foodNutrient.getNutrientId2().equals(1004L)){
////                    sumOfFat += foodNutrient.getValue() * 100 / foodConsumedByUser.getAmount();
////                }
////                if (foodNutrient.getNutrientId2().equals(1005L)){
////                    sumOfCarbohydrate += foodNutrient.getValue() * 100 / foodConsumedByUser.getAmount();
////                }
////            }
////        }
////
////        System.out.println(sumOfProteins);
////
////        MacroNutrientsDTO mn = MacroNutrientsDTO.builder()
////                .protein(sumOfProteins)
////                .fat(sumOfFat)
////                .carbohydrate(sumOfCarbohydrate)
////                .build();
////        return mn;
////        HashMap<String, Integer> map = new HashMap<>();
////        map.put("1003", 90);
////        map.put("1004", 10);
////        map.put("1005", 50);
////        return map;
//    return null;
//    }
}
