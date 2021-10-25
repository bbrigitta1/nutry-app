package com.example.nutry.config;

import com.example.nutry.model.*;
import com.example.nutry.repository.AddedFoodRepository;
import com.example.nutry.repository.NutrientRepository;
import com.example.nutry.repository.UserRepository;
import com.example.nutry.service.AddedFoodService;
import com.example.nutry.service.NutrientService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class NutrientConfig {

    @Autowired
    NutrientService nutrientService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddedFoodService addedFoodService;

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    CommandLineRunner commandLineRunnerAddNutrient() {
        return args -> {

            Nutrient nutrient1 = Nutrient.builder()
                    .nutrientId2(1087L)
                    .nutrientName("Calcium, Ca")
                    .unitName("MG")
                    .build();

            Nutrient nutrient2 = Nutrient.builder()
                    .nutrientId2(1003L)
                    .nutrientName("Protein")
                    .unitName("G")
                    .build();

            Nutrient nutrient3 = Nutrient.builder()
                    .nutrientId2(1004L)
                    .nutrientName("Total lipid (fat)")
                    .unitName("G")
                    .build();

            Nutrient nutrient4 = Nutrient.builder()
                    .nutrientId2(1005L)
                    .nutrientName("Carbohydrate, by difference")
                    .unitName("MG")
                    .build();

            Nutrient nutrient5 = Nutrient.builder()
                    .nutrientId2(1008L)
                    .nutrientName("Energy")
                    .unitName("KCAL")
                    .build();

            Nutrient nutrient6 = Nutrient.builder()
                    .nutrientId2(1018L)
                    .nutrientName("Alcohol")
                    .unitName("G")
                    .build();

            Nutrient nutrient7 = Nutrient.builder()
                    .nutrientId2(1051L)
                    .nutrientName("Water")
                    .unitName("G")
                    .build();

            Nutrient nutrient8 = Nutrient.builder()
                    .nutrientId2(1057L)
                    .nutrientName("Caffeine")
                    .unitName("MG")
                    .build();

            Nutrient nutrient9 = Nutrient.builder()
                    .nutrientId2(1058L)
                    .nutrientName("Theobromine")
                    .unitName("MG")
                    .build();
            Nutrient nutrient10 = Nutrient.builder()
                    .nutrientId2(2000L)
                    .nutrientName("Sugars")
                    .unitName("G")
                    .build();
            Nutrient nutrien11 = Nutrient.builder()
                    .nutrientId2(1079L)
                    .nutrientName("Fiber")
                    .unitName("G")
                    .build();
            Nutrient nutrient12 = Nutrient.builder()
                    .nutrientId2(1089L)
                    .nutrientName("Iron, Fe")
                    .unitName("MG")
                    .build();
            Nutrient nutrient13 = Nutrient.builder()
                    .nutrientId2(1090L)
                    .nutrientName("Magnesium, Mg")
                    .unitName("MG")
                    .build();
            Nutrient nutrient14 = Nutrient.builder()
                    .nutrientId2(1091L)
                    .nutrientName("Phosphorus, P")
                    .unitName("MG")
                    .build();
            Nutrient nutrient15 = Nutrient.builder()
                    .nutrientId2(1092L)
                    .nutrientName("Potassium, K")
                    .unitName("MG")
                    .build();
            Nutrient nutrient16 = Nutrient.builder()
                    .nutrientId2(1093L)
                    .nutrientName("Sodium")
                    .unitName("MG")
                    .build();
            Nutrient nutrient17= Nutrient.builder()
                    .nutrientId2(1095L)
                    .nutrientName("Zinc")
                    .unitName("MG")
                    .build();
            Nutrient nutrient18= Nutrient.builder()
                    .nutrientId2(1098L)
                    .nutrientName("Coppoer, Cu")
                    .unitName("MG")
                    .build();
            Nutrient nutrient19= Nutrient.builder()
                    .nutrientId2(1103L)
                    .nutrientName("Selenium")
                    .unitName("UG")
                    .build();
            Nutrient nutrient20= Nutrient.builder()
                    .nutrientId2(1105L)
                    .nutrientName("Retinol")
                    .unitName("UG")
                    .build();
            Nutrient nutrient21= Nutrient.builder()
                    .nutrientId2(1106L)
                    .nutrientName("Vitamin A")
                    .unitName("UG")
                    .build();
            Nutrient nutrient22= Nutrient.builder()
                    .nutrientId2(1107L)
                    .nutrientName("Carotene, beta")
                    .unitName("UG")
                    .build();
            Nutrient nutrient23= Nutrient.builder()
                    .nutrientId2(1108L)
                    .nutrientName("Carotene, alpha")
                    .unitName("UG")
                    .build();
            Nutrient nutrient24= Nutrient.builder()
                    .nutrientId2(1109L)
                    .nutrientName("Vitamin E")
                    .unitName("MG")
                    .build();
            Nutrient nutrient25= Nutrient.builder()
                    .nutrientId2(1114L)
                    .nutrientName("Vitamin D (D2 + D3)")
                    .unitName("UG")
                    .build();

            Nutrient nutrient26= Nutrient.builder()
                    .nutrientId2(1120L)
                    .nutrientName("Cryptoxanthin, beta")
                    .unitName("UG")
                    .build();

            Nutrient nutrient27= Nutrient.builder()
                    .nutrientId2(1122L)
                    .nutrientName("Lycopene")
                    .unitName("UG")
                    .build();
            Nutrient nutrient28= Nutrient.builder()
                    .nutrientId2(1123L)
                    .nutrientName("Lutein + zeaxanthin")
                    .unitName("UG")
                    .build();
            Nutrient nutrient29= Nutrient.builder()
                    .nutrientId2(1162L)
                    .nutrientName("Vitamin C")
                    .unitName("MG")
                    .build();
            Nutrient nutrient30= Nutrient.builder()
                    .nutrientId2(1165L)
                    .nutrientName("Thiamin")
                    .unitName("MG")
                    .build();

            Nutrient nutrient31= Nutrient.builder()
                    .nutrientId2(1166L)
                    .nutrientName("Riboflavin")
                    .unitName("MG")
                    .build();


            Nutrient nutrient32= Nutrient.builder()
                    .nutrientId2(1167L)
                    .nutrientName("Niacin")
                    .unitName("MG")
                    .build();
            Nutrient nutrient33= Nutrient.builder()
                    .nutrientId2(1175L)
                    .nutrientName("Vitamin B6")
                    .unitName("MG")
                    .build();
            Nutrient nutrient34= Nutrient.builder()
                    .nutrientId2(1177L)
                    .nutrientName("Folate")
                    .unitName("UG")
                    .build();
            Nutrient nutrient35= Nutrient.builder()
                    .nutrientId2(1178L)
                    .nutrientName("Vitamin B12")
                    .unitName("UG")
                    .build();

            Nutrient nutrient36= Nutrient.builder()
                    .nutrientId2(1180L)
                    .nutrientName("Choline")
                    .unitName("MG")
                    .build();


            Nutrient nutrient37= Nutrient.builder()
                    .nutrientId2(1185L)
                    .nutrientName("Vitamin K")
                    .unitName("UG")
                    .build();
            Nutrient nutrient38 = Nutrient.builder()
                    .nutrientId2(1186L)
                    .nutrientName("Folic acid")
                    .unitName("UG")
                    .build();
            Nutrient nutrient39 = Nutrient.builder()
                    .nutrientId2(1187L)
                    .nutrientName("Folate, food")
                    .unitName("UG")
                    .build();
            Nutrient nutrient40 = Nutrient.builder()
                    .nutrientId2(1190L)
                    .nutrientName("Folate, DFE")
                    .unitName("UG")
                    .build();

            Nutrient nutrient41 = Nutrient.builder()
                    .nutrientId2(1242L)
                    .nutrientName("Vitamin E, added")
                    .unitName("MG")
                    .build();

            Nutrient nutrient42 = Nutrient.builder()
                    .nutrientId2(1246L)
                    .nutrientName("Vitamin B12, added")
                    .unitName("UG")
                    .build();
            Nutrient nutrient43 = Nutrient.builder()
                    .nutrientId2(1253L)
                    .nutrientName("Cholesterol")
                    .unitName("MG")
                    .build();
            Nutrient nutrient44 = Nutrient.builder()
                    .nutrientId2(1258L)
                    .nutrientName("Fatty acids, total saturated")
                    .unitName("G")
                    .build();
//            Nutrient nutrient4 = Nutrient.builder()
//                    .nutrientId2(1005L)
//                    .nutrientName("Carbohydrate")
//                    .unitName("MG")
//                    .build();
//            Nutrient nutrient4 = Nutrient.builder()
//                    .nutrientId2(1005L)
//                    .nutrientName("Carbohydrate")
//                    .unitName("MG")
//                    .build();
//            Nutrient nutrient4 = Nutrient.builder()
//                    .nutrientId2(1005L)
//                    .nutrientName("Carbohydrate")
//                    .unitName("MG")
//                    .build();
//            Nutrient nutrient4 = Nutrient.builder()
//                    .nutrientId2(1005L)
//                    .nutrientName("Carbohydrate")
//                    .unitName("MG")
//                    .build();




            User user = User.builder()
                    .userName("exampleuser")
                    .password(passwordEncoder.encode("password"))
                    .roles(Arrays.asList("ROLE_USER"))
                    .build();

            UserDetails userDetails = UserDetails.builder()
                    .height(180)
                    .weight(80)
                    .activity(1.1)
                    .gender(0.0)
                    .age(30)
                    .user(user)
                    .goal(1.0)
                    .date(LocalDate.now())
                    .build();

            user.setUserDetails(Lists.newArrayList(userDetails));

            userRepository.save(user);

            nutrientService.save(nutrient1);
            nutrientService.save(nutrient2);
            nutrientService.save(nutrient3);
            nutrientService.save(nutrient4);


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
//                    .foodNutrients(food.getFoodNutrients())
                    .foodConsumed(Lists.newArrayList(foodConsumed))
                    .build();
            foodConsumed.setFood(foodNew);

            Food foodNew2 = Food.builder()
                    .description("Ham")
                    .fdcId(1669L)
                    .energy(45)
//                    .foodNutrients(food.getFoodNutrients())
                    .foodConsumed(Lists.newArrayList(foodConsumed2))
                    .build();
            foodConsumed2.setFood(foodNew2);



            FoodNutrient protein = FoodNutrient.builder()
                    .nutrientId2(1003L)
                    .value(13.8)
                    .food(foodNew)
                    .nutrient(nutrient2)
                    .build();

            FoodNutrient fat = FoodNutrient.builder()
                    .nutrientId2(1004L)
                    .value(20.5)
                    .food(foodNew)
                    .nutrient(nutrient3)
                    .build();

            FoodNutrient carbohydrate = FoodNutrient.builder()
                    .nutrientId2(1005L)
                    .value(50.8)
                    .food(foodNew)
                    .nutrient(nutrient4)
                    .build();

            FoodNutrient protein2 = FoodNutrient.builder()
                    .nutrientId2(1003L)
                    .value(13.8)
                    .food(foodNew2)
                    .nutrient(nutrient2)
                    .build();

            FoodNutrient fat2 = FoodNutrient.builder()
                    .nutrientId2(1004L)
                    .value(20.5)
                    .food(foodNew2)
                    .nutrient(nutrient3)
                    .build();

            FoodNutrient carbohydrate2 = FoodNutrient.builder()
                    .nutrientId2(1005L)
                    .value(50.8)
                    .food(foodNew2)
                    .nutrient(nutrient4)
                    .build();


            foodNew.setFoodNutrients(List.of(protein, fat, carbohydrate));
            foodNew2.setFoodNutrients(List.of(protein2, fat2, carbohydrate2));

            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew)));
            foodNew.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setFood(foodNew2)));
            foodNew2.getFoodNutrients().forEach((foodNutrient1 -> foodNutrient1.setNutrient(nutrientService.getByNutrientId2(foodNutrient1.getNutrientId2()))));

            addedFoodService.save(foodNew);
            addedFoodService.save(foodNew2);

        };
    }
};

