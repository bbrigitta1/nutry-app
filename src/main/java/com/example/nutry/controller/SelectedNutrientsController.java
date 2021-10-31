package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class SelectedNutrientsController {

    //DTO -> MacroNutrents.class

    @Autowired
    private FoodConsumedService foodConsumedService;

    @Autowired
    private DashBoardService dashBoardService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private NutrientService nutrientService;




    @PostMapping("/select-custom-nutrient")
    public void selectCustomNutrient(@RequestBody Authentication authentication) {
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));

    }

}
