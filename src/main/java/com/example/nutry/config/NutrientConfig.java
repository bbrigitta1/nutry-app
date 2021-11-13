package com.example.nutry.config;

import com.example.nutry.model.*;
import com.example.nutry.repository.*;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.NutrientService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class NutrientConfig {

    @Autowired
    NutrientService nutrientService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddedFoodService addedFoodService;

    @Autowired
    DriLifeStageRepository driLifeStageRepository;

    @Autowired
    DriNutrientRepository driNutrientRepository;

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    CommandLineRunner commandLineRunnerAddNutrient() {
        return args -> {

            Nutrient nutrient1 = Nutrient.builder()
                    .nutrientId2(1087L)
                    .nutrientName("Calcium, Ca")
                    .unitName("MG")
                    .category("Minerals")
                    .build();

            Nutrient nutrient2 = Nutrient.builder()
                    .nutrientId2(1003L)
                    .nutrientName("Protein")
                    .unitName("G")
                    .category("Protein")
                    .build();

            Nutrient nutrient3 = Nutrient.builder()
                    .nutrientId2(1004L)
                    .nutrientName("Total lipid (fat)")
                    .unitName("G")
                    .category("Lipids")
                    .build();

            Nutrient nutrient4 = Nutrient.builder()
                    .nutrientId2(1005L)
                    .nutrientName("Carbohydrate, by difference")
                    .unitName("G")
                    .category("Carbohydrates")
                    .build();

            Nutrient nutrient5 = Nutrient.builder()
                    .nutrientId2(1008L)
                    .nutrientName("Energy")
                    .unitName("KCAL")
                    .category("General")
                    .build();

            Nutrient nutrient6 = Nutrient.builder()
                    .nutrientId2(1018L)
                    .nutrientName("Alcohol")
                    .unitName("G")
                    .category("General")
                    .build();

            Nutrient nutrient7 = Nutrient.builder()
                    .nutrientId2(1051L)
                    .nutrientName("Water")
                    .unitName("L")
                    .category("General")
                    .build();

            Nutrient nutrient8 = Nutrient.builder()
                    .nutrientId2(1057L)
                    .nutrientName("Caffeine")
                    .unitName("MG")
                    .category("General")
                    .build();

            Nutrient nutrient9 = Nutrient.builder()
                    .nutrientId2(1058L)
                    .nutrientName("Theobromine")
                    .unitName("MG")
                    .category("Others")
                    .build();
            Nutrient nutrient10 = Nutrient.builder()
                    .nutrientId2(2000L)
                    .nutrientName("Sugars")
                    .unitName("G")
                    .category("Carbohydrates")
                    .build();
            Nutrient nutrien11 = Nutrient.builder()
                    .nutrientId2(1079L)
                    .nutrientName("Fiber")
                    .unitName("G")
                    .category("Carbohydrates")
                    .build();
            Nutrient nutrient12 = Nutrient.builder()
                    .nutrientId2(1089L)
                    .nutrientName("Iron, Fe")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient13 = Nutrient.builder()
                    .nutrientId2(1090L)
                    .nutrientName("Magnesium, Mg")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient14 = Nutrient.builder()
                    .nutrientId2(1091L)
                    .nutrientName("Phosphorus, P")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient15 = Nutrient.builder()
                    .nutrientId2(1092L)
                    .nutrientName("Potassium, K")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient16 = Nutrient.builder()
                    .nutrientId2(1093L)
                    .nutrientName("Sodium")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient17= Nutrient.builder()
                    .nutrientId2(1095L)
                    .nutrientName("Zinc")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient18= Nutrient.builder()
                    .nutrientId2(1098L)
                    .nutrientName("Coppoer, Cu")
                    .unitName("MG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient19= Nutrient.builder()
                    .nutrientId2(1103L)
                    .nutrientName("Selenium")
                    .unitName("UG")
                    .category("Minerals")
                    .build();
            Nutrient nutrient20= Nutrient.builder()
                    .nutrientId2(1105L)
                    .nutrientName("Retinol")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient21= Nutrient.builder()
                    .nutrientId2(1106L)
                    .nutrientName("Vitamin A")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient22= Nutrient.builder()
                    .nutrientId2(1107L)
                    .nutrientName("Carotene, beta")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient23= Nutrient.builder()
                    .nutrientId2(1108L)
                    .nutrientName("Carotene, alpha")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient24= Nutrient.builder()
                    .nutrientId2(1109L)
                    .nutrientName("Vitamin E")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient25= Nutrient.builder()
                    .nutrientId2(1114L)
                    .nutrientName("Vitamin D (D2 + D3)")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient26= Nutrient.builder()
                    .nutrientId2(1120L)
                    .nutrientName("Cryptoxanthin, beta")
                    .unitName("UG")
                    .category("Others")
                    .build();

            Nutrient nutrient27= Nutrient.builder()
                    .nutrientId2(1122L)
                    .nutrientName("Lycopene")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient28= Nutrient.builder()
                    .nutrientId2(1123L)
                    .nutrientName("Lutein + zeaxanthin")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient29= Nutrient.builder()
                    .nutrientId2(1162L)
                    .nutrientName("Vitamin C")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient30= Nutrient.builder()
                    .nutrientId2(1165L)
                    .nutrientName("Vitamin B1 (Thiamin)")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient31= Nutrient.builder()
                    .nutrientId2(1166L)
                    .nutrientName("Vitamin B2 (Riboflavin)")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();


            Nutrient nutrient32= Nutrient.builder()
                    .nutrientId2(1167L)
                    .nutrientName("Vitamin B2 (Niacin)")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient33= Nutrient.builder()
                    .nutrientId2(1175L)
                    .nutrientName("Vitamin B6")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient34= Nutrient.builder()
                    .nutrientId2(1177L)
                    .nutrientName("Folate")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient35= Nutrient.builder()
                    .nutrientId2(1178L)
                    .nutrientName("Vitamin B12")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient36= Nutrient.builder()
                    .nutrientId2(1180L)
                    .nutrientName("Vitamin B8 (Choline)")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient37= Nutrient.builder()
                    .nutrientId2(1185L)
                    .nutrientName("Vitamin K")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient38 = Nutrient.builder()
                    .nutrientId2(1186L)
                    .nutrientName("Folic acid")
                    .unitName("UG")
                    .category("Others")
                    .build();
            Nutrient nutrient39 = Nutrient.builder()
                    .nutrientId2(1187L)
                    .nutrientName("Folate, food")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient40 = Nutrient.builder()
                    .nutrientId2(1190L)
                    .nutrientName("Folate, DFE")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient41 = Nutrient.builder()
                    .nutrientId2(1242L)
                    .nutrientName("Vitamin E, added")
                    .unitName("MG")
                    .category("Vitamins")
                    .build();

            Nutrient nutrient42 = Nutrient.builder()
                    .nutrientId2(1246L)
                    .nutrientName("Vitamin B12, added")
                    .unitName("UG")
                    .category("Vitamins")
                    .build();
            Nutrient nutrient43 = Nutrient.builder()
                    .nutrientId2(1253L)
                    .nutrientName("Cholesterol")
                    .unitName("MG")
                    .category("Lipids")
                    .build();
            Nutrient nutrient44 = Nutrient.builder()
                    .nutrientId2(1258L)
                    .nutrientName("Fatty acids, total saturated")
                    .unitName("G")
                    .category("Lipids")
                    .build();
            Nutrient nutrient45 = Nutrient.builder()
                    .nutrientId2(1292L)
                    .nutrientName("Fatty acids, total monounsaturated")
                    .unitName("G")
                    .category("Lipids")
                    .build();
            Nutrient nutrient46 = Nutrient.builder()
                    .nutrientId2(1293L)
                    .nutrientName("Fatty acids, total polyunsaturated")
                    .unitName("G")
                    .category("Lipids")
                    .build();


            User user = User.builder()
                    .userName("exampleuser")
                    .email("examp@examp.com")
                    .password(passwordEncoder.encode("password"))
                    .roles(Arrays.asList("ROLE_USER"))
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .height(180)
                    .weight(80)
                    .activity(1.1)
                    .gender(0.0)
                    .birthdate(LocalDate.of(1991,11,17))
                    .age(30)
                    .user(user)
                    .goal(1.0)
                    .date(LocalDate.of(2021,10,1))
                    .build();

            user.setUserDetails(Lists.newArrayList(userDetails));

            userRepository.save(user);

            List<Nutrient> nutrients = List.of(nutrient1, nutrient2, nutrient3,  nutrient4, nutrient5,nutrient6,nutrient7,nutrient8,nutrient9, nutrient10,nutrien11,nutrient12,nutrient13,nutrient14,nutrient15,nutrient16, nutrient17, nutrient18, nutrient19, nutrient20, nutrient21, nutrient22, nutrient23, nutrient24, nutrient25, nutrient26, nutrient27, nutrient28, nutrient29, nutrient30, nutrient31, nutrient32, nutrient33, nutrient34, nutrient35, nutrient36, nutrient37, nutrient38, nutrient39, nutrient40, nutrient41, nutrient42, nutrient43, nutrient44, nutrient45, nutrient46);
            nutrientService.saveAll(nutrients);


            User exampleUser = userRepository.findAll().get(0);

            FoodConsumed foodConsumed = FoodConsumed.builder()
                    .amount(100)
                    .consumptionDate(LocalDate.of(2021, 10, 24))
                    .user(exampleUser)
                    .build();

            FoodConsumed foodConsumed2 = FoodConsumed.builder()
                    .amount(100)
                    .consumptionDate(LocalDate.of(2021, 10, 24))
                    .user(exampleUser)
                    .build();
            exampleUser.setFoodConsumeds(Lists.newArrayList(foodConsumed, foodConsumed2));


            Food foodNew = Food.builder()
                    .description("Apple")
                    .fdcId(1555L)
                    .energy(45)
                    .foodConsumed(Lists.newArrayList(foodConsumed))
                    .build();
            foodConsumed.setFood(foodNew);

            Food foodNew2 = Food.builder()
                    .description("Ham")
                    .fdcId(1669L)
                    .energy(45)
                    .foodConsumed(Lists.newArrayList(foodConsumed2))
                    .build();
            foodConsumed2.setFood(foodNew2);

            List<FoodNutrient> foodNutrientsDummyFood = new ArrayList<>();
            for (Nutrient nutrient: nutrients) {
                foodNutrientsDummyFood.add(
                        FoodNutrient.builder()
                        .nutrientId2(nutrient.getNutrientId2())
                        .value(10.9)
                        .food(foodNew)
                        .nutrient(nutrient)
                        .build());
            }

            List<FoodNutrient> foodNutrientsDummyFood2 = new ArrayList<>();
            for (Nutrient nutrient: nutrients) {
                foodNutrientsDummyFood2.add(
                        FoodNutrient.builder()
                        .nutrientId2(nutrient.getNutrientId2())
                        .value(10.9)
                        .food(foodNew2)
                        .nutrient(nutrient)
                        .build());
            }

            foodNew.setFoodNutrients(foodNutrientsDummyFood);
            foodNew2.setFoodNutrients(foodNutrientsDummyFood2);

            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew)));
            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew2)));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));

            addedFoodService.save(foodNew);
            addedFoodService.save(foodNew2);

            //Config of recommended nutrients:

            List<String> femaleDataFiltered = Files.lines(Paths.get("src/main/resources/dri_data.txt"))
                    .filter(x -> x.contains("Female"))
                    .collect(Collectors.toList());
            List<String[]> splitFemaleDataFiltered = femaleDataFiltered
                    .stream()
                    .map(x -> x.split("-"))
                    .collect(Collectors.toList());


            List<String> maleDataFiltered = Files.lines(Paths.get("src/main/resources/dri_data.txt"))
                    .filter(x -> x.contains("Male"))
                    .collect(Collectors.toList());
            List<String[]> splitMaleDataFiltered = maleDataFiltered
                    .stream()
                    .map(x -> x.split("-"))
                    .collect(Collectors.toList());

            Map<String, Double> femaleDataMap = new HashMap<>();
            Map<String, Double> maleDataMap = new HashMap<>();

            for (String[] data : splitFemaleDataFiltered) {
                if (!data[3].equals("ND")) {
                    femaleDataMap.put(data[2], Double.parseDouble(data[3]));
                } else {
                    femaleDataMap.put(data[2], 0.0);
                }
            }

            for (String[] data : splitMaleDataFiltered) {
                if (!data[3].equals("ND")) {
                    maleDataMap.put(data[2], Double.parseDouble(data[3]));
                } else {
                    maleDataMap.put(data[2], 0.0);
                }
            }

            DriLifeStage male = DriLifeStage.builder()
                    .gender(0.0)
                    .stageType("General")
                    .ageFrom(31)
                    .ageTo(50)
                    .build();

            DriLifeStage female = DriLifeStage.builder()
                    .gender(1.0)
                    .stageType("General")
                    .ageFrom(31)
                    .ageTo(50)
                    .build();

            List<DriNutrient> driNutrientsMale = new ArrayList<>();
            List<DriNutrient> driNutrientsFemale = new ArrayList<>();

            for(Nutrient nutrient: nutrients) {
                driNutrientsMale.add(
                        DriNutrient.builder()
                                .nutrient(nutrient)
                                .recommended(maleDataMap.get(nutrient.getNutrientName()))
                                .driLifeStage(male)
                                .build()
                );
                driNutrientsFemale.add(
                        DriNutrient.builder()
                                .nutrient(nutrient)
                                .recommended(femaleDataMap.get(nutrient.getNutrientName()))
                                .driLifeStage(female)
                                .build()
                );
            }
            male.setDriNutrients(driNutrientsMale);
            female.setDriNutrients(driNutrientsFemale);
            male.getDriNutrients().forEach((drinutrient -> drinutrient.setDriLifeStage(male)));
            female.getDriNutrients().forEach((drinutrient -> drinutrient.setDriLifeStage(female)));
            male.getDriNutrients().forEach((drinutrient -> drinutrient.setNutrient(nutrientService.getByNutrientId2(drinutrient.getNutrient().getNutrientId2()))));
            female.getDriNutrients().forEach((drinutrient -> drinutrient.setNutrient(nutrientService.getByNutrientId2(drinutrient.getNutrient().getNutrientId2()))));
            driLifeStageRepository.save(male);
            driLifeStageRepository.save(female);
        };
    }
};

