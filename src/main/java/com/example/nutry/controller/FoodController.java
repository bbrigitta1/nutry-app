package com.example.nutry.controller;

import com.example.nutry.model.AddedFood;
import com.example.nutry.model.Food;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.FoodService;
import com.example.nutry.service.IFoodService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class FoodController {



    @Autowired
    private FoodService foodService;



//    @PostMapping("/addfoodtomealplan")
//    public void saveFood(@RequestBody AddedFood addedFood){
//        Food food = new Food(addedFood.getDescription(), addedFood.getEnergy(), addedFood.getAmount());
//        System.out.println(addedFood);
//        foodService.save(food);
//    }
}
