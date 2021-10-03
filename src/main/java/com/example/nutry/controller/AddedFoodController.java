package com.example.nutry.controller;

import com.example.nutry.model.Food;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.FoodConsumedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class AddedFoodController {

    @Autowired
    private AddedFoodService addedFoodService;

    @Autowired
    private FoodConsumedService foodConsumedService;


    @GetMapping("/getallfoodsfortheday")
    public List<Food>  getAllFoodsFromDatabase() {
        List<Food> foods = addedFoodService.findAll();
        System.out.println(foods);
        return foods;
    }

    @PostMapping("/addfoodtomealplan")
    public void saveFood(@RequestBody Food food){
//        Food food = new Food(addedFood.getDescription(), addedFood.getEnergy(), addedFood.getAmount());
        System.out.println(food);
        try {
            addedFoodService.save(food);
        } catch(DataIntegrityViolationException e) {
            foodConsumedService.save(food.getFoodConsumed().get(0));
            System.out.println("Entity already exists. Skipping ...");
        }


    }

}
