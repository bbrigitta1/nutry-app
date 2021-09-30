package com.example.nutry.controller;

import com.example.nutry.model.AddedFood;
import com.example.nutry.model.FoodConsumed;
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
    public List<AddedFood>  getAllFoodsFromDatabase() {
        List<AddedFood> addedFoods = addedFoodService.findAll();
        System.out.println(addedFoods);
        return addedFoods;
    }

    @PostMapping("/addfoodtomealplan")
    public void saveFood(@RequestBody AddedFood addedFood){
//        Food food = new Food(addedFood.getDescription(), addedFood.getEnergy(), addedFood.getAmount());
        System.out.println(addedFood);
        try {
            addedFoodService.save(addedFood);
        } catch(DataIntegrityViolationException e) {
            foodConsumedService.save(addedFood.getFoodConsumed().get(0));
            System.out.println("Entity already exists. Skipping ...");
        }


    }

}
