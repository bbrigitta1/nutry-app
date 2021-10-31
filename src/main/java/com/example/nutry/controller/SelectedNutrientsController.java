package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.service.*;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class SelectedNutrientsController {
    

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

    @Autowired
    private NutrientSelectionService selectedNutrientService;


    @PostMapping("/select-custom-nutrient")
    public void selectCustomNutrient(@RequestBody SelectedNutrientListDTO selectedNutrientList, Authentication authentication){
        System.out.println(selectedNutrientList);
        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        if (selectedNutrientService.findNutrientSelectionByUser(user) != null){
            selectedNutrientService.deleteByUser(user);
        }
        System.out.println("nutry");
        List<Nutrient> nutrientList = new ArrayList<>();
        for (SelectedNutrientDTO nutrient : selectedNutrientList.getSelectedNutrientList()){
            if (nutrientService.getByNutrientId2(nutrient.getNutrientID())!= null){
                nutrientList.add(nutrientService.getByNutrientId2(nutrient.getNutrientID()));
            }
        }
        NutrientSelection nutrientSelection = NutrientSelection.builder()
                .user(user)
                .selectedNutrients(Lists.newArrayList(nutrientList))
                .build();
        selectedNutrientService.save(nutrientSelection);

    }

    @PostMapping("/getselectednutrients")
    public List<MicroNutrientDTO> getSelectedNutrients(@RequestBody SelectedDateDTO selectedDate, Authentication authentication) {
        System.out.println("helllloo");

        User user = userService.findUserByEmail(String.valueOf(authentication.getPrincipal()));
        List<MicroNutrientDTO> selectedNutrients = new ArrayList<>();
        NutrientSelection nutrientSelection = selectedNutrientService.findNutrientSelectionByUser(user);
        for (Nutrient nutrient : nutrientSelection.getSelectedNutrients()){
            selectedNutrients.add(getMicroNutrient(selectedDate, nutrient.getNutrientId2()));
        }
        System.out.println(selectedNutrients);
        return selectedNutrients;
    }


    private MicroNutrientDTO getMicroNutrient(SelectedDateDTO selectedDate, Long nutrientID) {
        User user = userService.findById(1L);
        List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, selectedDate.getDate());
        Double sumOfNutrient = 0.0;
        for (FoodConsumed foodConsumedByUser : foodsConsumedByUser) {
            for (FoodNutrient foodNutrient : foodConsumedByUser.getFood().getFoodNutrients()) {
                if (foodNutrient.getNutrientId2().equals(nutrientID)) {
                    sumOfNutrient += foodNutrient.getValue() * foodConsumedByUser.getAmount() / 100;
                }
            }
        }

        MicroNutrientDTO microNutrientDTO = MicroNutrientDTO.builder()
                .nutrientName(nutrientService.getNutrientNameByNutrientId2(nutrientID))
                .amount(sumOfNutrient)
                .build();
        return microNutrientDTO;
    }
}
