package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping("/getenergyhistory")
    public List<EnergyHistoryDTO> getEnergyForPeriod (@RequestBody EnergyPeriodDTO energyPeriodDTO) {
        List<EnergyHistoryDTO> result = new ArrayList<>();
        User user = userService.findById(1L);
        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(2);

//        LocalDate end = LocalDate.of(2021, 9, 3);
//        LocalDate start = LocalDate.of(2021, 8, 30);

        List<LocalDate> dateList = start.datesUntil(end)
                    .collect(Collectors.toList());
        System.out.println(dateList);

        for (LocalDate dat : dateList) {
            LocalDate date = dat;
            Integer consumed =0;
            Integer recommended = 0;

            UserDetails userDetails = getUserDetailsForDate(date, user);
            if (userDetails != null) {
                recommended += calcRecommendedCaloriesByUserDetails(userDetails);
            }

            List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, dat);
            for (FoodConsumed foodConsumed : foodsConsumedByUser ) {

                consumed += foodConsumed.getFood().getEnergy()*foodConsumed.getAmount()/100;
            }
            EnergyHistoryDTO energyHistoryDTO = EnergyHistoryDTO.builder()
                    .date(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                    //.date("valami")
                    .consumed(consumed)
                    .recommended(recommended)
                    .build();
            result.add(energyHistoryDTO);
        }
        System.out.println(result);
        return result;
    }

    public UserDetails getUserDetailsForDate(LocalDate date, User user) {
        return userDetailsService.findLatestByDateAndUser(date, user);
    }

    public Integer calcRecommendedCaloriesByUserDetails(UserDetails userDetails) {
        return  (int)((10 * userDetails.getWeight()
                + 6.25 * userDetails.getHeight()
                - 5 * userDetails.getAge()
                + userDetails.getGender()) * userDetails.getActivity() * userDetails.getGoal());
    }




}
