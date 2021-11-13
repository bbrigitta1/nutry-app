package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.FoodConsumedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins="${crossorigin}")
public class ResultController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    FoodConsumedService foodConsumedService;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping("/search/{searchWord}")
    public String getSearchResult(@PathVariable("searchWord") String searchWord) {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key="+apiKey+"&query="+searchWord+"&dataType=Survey (FNDDS)";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/addwater")
    public String getWater(Authentication authentication) throws JsonProcessingException {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key="+apiKey+"&query="+"water"+"&dataType=Survey (FNDDS)";
        RestTemplate rt = new RestTemplate();
        String result = rt.getForObject(uri, String.class);
        return result;

//        //check db if there is water already in
//        User user = userRepository.findUserByEmail(String.valueOf(authentication.getPrincipal()));
//        List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, selectedDate.getDate());
//        for (FoodConsumed foodConsumed : foodsConsumedByUser ) {
//            if (foodConsumed.getFood().getFdcId().equals(1104492L)) {
//                //
//                ///v1/food/{fdcId}
//                //RestTemplate rt = new RestTemplate();
//                //String result = rt.getForObject(uri, String.class);
//
//
//                FoodConsumed foodConsumed = FoodConsumed.builder()
//                        .amount(100)
//                        .consumptionDate(food.getDate())
//                        .user(exampleUser)
//                        .build();
//                exampleUser.setFoodConsumeds(Lists.newArrayList(foodConsumed));
//
//                if (addedFoodService.findByFcdId(food.getFdcId()) == null) {
//                    Food foodNew = Food.builder()
//                            .description(food.getDescription())
//                            .fdcId(food.getFdcId())
//                            .energy(food.getEnergy())
//                            .foodNutrients(food.getFoodNutrients())
//                            .foodConsumed(Lists.newArrayList(foodConsumed))
//                            .build();
//                    foodConsumed.setFood(foodNew);
//
//                    foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew)));
//                    foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));
//
//                    addedFoodService.save(foodNew);
//                } else {
//                    Food foodAlreadyInDatabase = addedFoodService.findByFcdId(food.getFdcId());
//                    foodConsumed.setFood(foodAlreadyInDatabase);
//                    foodConsumedService.save(foodConsumed);
//                }
//            }
//        }
        //FoodConsumed water = foodConsumedService.



    }

}
