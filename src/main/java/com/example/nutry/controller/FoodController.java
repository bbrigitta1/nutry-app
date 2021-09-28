package com.example.nutry.controller;

import com.example.nutry.model.Food;
import com.example.nutry.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins="http://localhost:3000")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @GetMapping("/show-foods")
    public String findFoods(Model model) {
        var foods = (List<Food>) foodService.findAll();
        System.out.println(foods);

        //pass foods to thymeleaf template
        model.addAttribute("foods", foods);

        return "showFoods";
    }

    @PostMapping("/addfood")
    public String addFood(@RequestBody Food food) {
        System.out.println(food.toString());
        foodService.save(food);
        return "added";
    }
}
