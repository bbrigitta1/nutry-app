package com.example.nutry.controller;

import com.example.nutry.model.*;
import com.example.nutry.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="${crossorigin}")
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

    @Autowired
    private NutrientService nutrientService;

    @Autowired
    private DriNutrientService driNutrientService;

    @Autowired
    private DriLifeStageService driLifeStageService;


//    @PostMapping("/get-recommended-nutrients")
//    public List<NutrientsRecommendedDTO> getNutrientsRecommended(@RequestBody PeriodDTO periodDTO) {
//        User user = userService.findById(1L);
//
//        List<DriNutrient> driNutrients = driNutrientService.findAllByLifeStage(driLifeStageService.findByGender(0.0));   //TODO connect user and lifeStage
//
//        List<NutrientsRecommendedDTO> nutrientsRecommendedDTOS = new ArrayList<>();
//
//        for (DriNutrient driNutrient:driNutrients) {
//            nutrientsRecommendedDTOS.add(
//                    NutrientsRecommendedDTO.builder()
//                            .recommended(driNutrient.getRecommended())
//                            .nutrientName(driNutrient.getNutrient().getNutrientName())
//                            .unitName(driNutrient.getNutrient().getUnitName())
//                            .category(driNutrient.getNutrient().getCategory())
//                            .nutrientId2(driNutrient.getNutrient().getNutrientId2())
//                            .build()
//            );
//        }
//        return nutrientsRecommendedDTOS;
//    }

    public List<NutrientsRecommendedDTO> getNutrientsRecommendedFromDb() {
        User user = userService.findById(1L);

        List<DriNutrient> driNutrients = driNutrientService.findAllByLifeStage(driLifeStageService.findByGender(0.0));   //TODO connect user and lifeStage

        List<NutrientsRecommendedDTO> nutrientsRecommendedDTOS = new ArrayList<>();

        for (DriNutrient driNutrient:driNutrients) {
            nutrientsRecommendedDTOS.add(
                    NutrientsRecommendedDTO.builder()
                            .recommended(driNutrient.getRecommended())
                            .nutrientName(driNutrient.getNutrient().getNutrientName())
                            .unitName(driNutrient.getNutrient().getUnitName())
                            .category(driNutrient.getNutrient().getCategory())
                            .nutrientId2(driNutrient.getNutrient().getNutrientId2())
                            .build()
            );
        }
        return nutrientsRecommendedDTOS;
    }

    @PostMapping("/get-avg-nutrients-for-period")
    public List<NutrientsConsumedAvgDTO> getAvgNutrientsForPeriod(@RequestBody PeriodDTO periodDTO) {
        User user = userService.findById(1L);

        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(periodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                .collect(Collectors.toList());

        Double nrOfDays = 0.0;

        Map<NutrientsDTO, Double> nutrientConsumption = new HashMap<>();

        for (LocalDate dat : dateList) {
            List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, dat);
//            System.out.println("consumed: " + foodsConsumedByUser.toString());
            if (!foodsConsumedByUser.isEmpty()) {
                nrOfDays += 1.0;
                for (FoodConsumed foodConsumed : foodsConsumedByUser ) {
                    for (FoodNutrient foodNutrient : foodConsumed.getFood().getFoodNutrients()) {
                        if (foodNutrient.getNutrient() != null) {
                            Nutrient actualFoodNutrient = foodNutrient.getNutrient();

//                            System.out.println("actfoodnutrient" + actualFoodNutrient.getNutrientName());
//                            System.out.println("check: " + foodNutrient.getNutrientId2().getClass());

                            NutrientsDTO nutrientsDTO = NutrientsDTO.builder()
                                    .nutrientId2(foodNutrient.getNutrientId2())
                                    //.nutrientName(nutrientService.getNutrientNameByNutrientId2(foodNutrient.getNutrientId2()))
                                    //.nutrientName(nutrientService.getNutrientNameByNutrientId2(1087L))
                                    .nutrientName(actualFoodNutrient.getNutrientName())
                                    .unitName(actualFoodNutrient.getUnitName())
                                    .category(actualFoodNutrient.getCategory())
                                    .build();

                            if (nutrientConsumption.containsKey(nutrientsDTO)) {
                                Double oldValue = nutrientConsumption.get(nutrientsDTO);
                                Double newValue = foodNutrient.getValue() * foodConsumed.getAmount() / 100;

                                nutrientConsumption.put(nutrientsDTO, oldValue + newValue);

                            } else {
                                nutrientConsumption.put(nutrientsDTO, 0.0);
                            }
                        }
                    }
                }
            }
        }
        List<DriNutrient> driNutrients = driNutrientService.findAllByLifeStage(driLifeStageService.findByGender(0.0));
        List<NutrientsConsumedAvgDTO> nutrientsConsumedDTOS = new ArrayList();

        for (Map.Entry<NutrientsDTO, Double> entry : nutrientConsumption.entrySet()) {
            NutrientsDTO key = entry.getKey();
            Double value = entry.getValue();
            nutrientConsumption.put(key, value/nrOfDays);
            NutrientsConsumedAvgDTO nutrientsConsumedAvgDTO = NutrientsConsumedAvgDTO.builder()
                    .avgConsumed(entry.getValue())
                    .recommended(driNutrientService.getByNutrientIdAndLifeStage(nutrientService.getByNutrientId2(entry.getKey().getNutrientId2()).getId(), driLifeStageService.findByGender(0.0)).getRecommended())  // TODO refactor
                    .category(entry.getKey().getCategory())
                    .nutrientName(entry.getKey().getNutrientName())
                    .unitName(entry.getKey().getUnitName())
                    .nutrientId2(entry.getKey().getNutrientId2())
                    .build();
            nutrientsConsumedDTOS.add(nutrientsConsumedAvgDTO);
        }
//        System.out.println(nutrientsConsumedDTOS.toString());
        return nutrientsConsumedDTOS;
    }


    @PostMapping("/get-avg-macronutrients-for-period")
    public MacroNutrientsDTO getAvgMacronutrientsForPeriod(@RequestBody PeriodDTO periodDTO) {
        User user = userService.findById(1L);

        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(periodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                .collect(Collectors.toList());

        Double sumOfProteins = 0.0;
        Double sumOfFat = 0.0;
        Double sumOfCarbohydrate = 0.0;
        Double nrOfDays = 0.0;

        for (LocalDate dat : dateList) {
            List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, dat);
            if (!foodsConsumedByUser.isEmpty()) {
                nrOfDays += 1.0;
                for (FoodConsumed foodConsumed : foodsConsumedByUser ) {
                    for (FoodNutrient foodNutrient : foodConsumed.getFood().getFoodNutrients()) {
                        if (foodNutrient.getNutrientId2().equals(1003L)) {
                            sumOfProteins += foodNutrient.getValue() * foodConsumed.getAmount() / 100;
                        }
                        if (foodNutrient.getNutrientId2().equals(1004L)) {
                            sumOfFat += foodNutrient.getValue() * foodConsumed.getAmount() / 100 ;
                        }
                        if (foodNutrient.getNutrientId2().equals(1005L)) {
                            sumOfCarbohydrate += foodNutrient.getValue() * foodConsumed.getAmount() / 100;
                        }
                    }
                }
            }
        }
        MacroNutrientsDTO macroNutrientsDTO = MacroNutrientsDTO.builder()
                .carbohydrate(sumOfCarbohydrate/nrOfDays)
                .fat(sumOfFat/nrOfDays)
                .protein(sumOfProteins/nrOfDays)
                .build();
        //System.out.println("Macro: " + macroNutrientsDTO);
        return macroNutrientsDTO;
    }

    @PostMapping("/getwaterhistory")
    public List<WaterHistoryDTO> getWaterForPeriod(@RequestBody PeriodDTO periodDTO) {
        List<WaterHistoryDTO> result = new ArrayList<>();

        User user = userService.findById(1L);

        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(periodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                .collect(Collectors.toList());

        for (LocalDate dat : dateList) {
            LocalDate date = dat;
            Integer actual =0;
            Integer target = 0;

            // TODO get from db
            Random rand = new Random();
            target += 3;
            actual += rand.nextInt(3-1) + 1;

            WaterHistoryDTO waterHistoryDTO = WaterHistoryDTO.builder()
                    .date(date.format(DateTimeFormatter.ofPattern("dd.MM")))
                    .actual(actual)
                    .target(target)
                    .build();
            result.add(waterHistoryDTO);
        }
        //System.out.println(result);
        return result;
    }

    @PostMapping("/getweighthistory")
    public List<WeightHistoryDTO> getWeightForPeriod(@RequestBody PeriodDTO periodDTO) {
        List<WeightHistoryDTO> result = new ArrayList<>();

        User user = userService.findById(1L);

        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(periodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                .collect(Collectors.toList());

        for (LocalDate dat : dateList) {
            LocalDate date = dat;
            Integer actual =0;
            Integer target = 0;

            // TODO get from db
            Random rand = new Random();
            target += 60;
            actual += rand.nextInt(75-67) + 67;

            WeightHistoryDTO weightHistoryDTO = WeightHistoryDTO.builder()
                    .date(date.format(DateTimeFormatter.ofPattern("dd.MM")))
                    .actual(actual)
                    .target(target)
                    .build();
            result.add(weightHistoryDTO);
        }
        //System.out.println(result);
        return result;
    }

    @PostMapping("/getenergyhistory")
    public List<EnergyHistoryDTO> getEnergyForPeriod (@RequestBody PeriodDTO energyPeriodDTO) {
        List<EnergyHistoryDTO> result = new ArrayList<>();
        User user = userService.findById(1L);
        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(energyPeriodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                    .collect(Collectors.toList());

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
                    .date(date.format(DateTimeFormatter.ofPattern("dd.MM")))
                    .consumed(consumed)
                    .recommended(recommended)
                    .build();
            result.add(energyHistoryDTO);
        }
        //System.out.println(result);
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
