package com.example.nutry.repository;

import com.example.nutry.model.FoodConsumed;
import com.example.nutry.model.MacroNutrientsDTO;
import com.example.nutry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FoodConsumedRepository extends JpaRepository<FoodConsumed, Long> {

    @Transactional
    List<FoodConsumed> findByUserOrderById(User user);

    List<FoodConsumed> findFoodConsumedsByUserAndConsumptionDate(User user, LocalDate date);

//    @Query("select subresult.nutrient_id2, sum(subresult.result) as res  from (\n" +
//            "                  select (100 / fc.amount * fn.value) as result,\n" +
//            "                         nutrient.nutrient_id2\n" +
//            "                  from nutrient\n" +
//            "                           left join food_nutrient fn on nutrient.id = fn.nutrient_id\n" +
//            "                           left join food_consumed fc on fn.food_id = fc.food_id\n" +
//            "                  where fc.user_id = 1 and fc.consumption_date = '2021-09-01'\n" +
//            "                  group by nutrient.id, fn.id, fc.id\n" +
//            "\n" +
//            "              ) as subresult group by subresult.nutrient_id2")
//    MacroNutrientsDTO getMacronutrients();


//    select subresult.nutrient_id2, sum(subresult.result) as res  from (
//    select (100 / fc.amount * fn.value) as result,
//    nutrient.nutrient_id2
//    from nutrient
//    left join food_nutrient fn on nutrient.id = fn.nutrient_id
//    left join food_consumed fc on fn.food_id = fc.food_id
//    where fc.user_id = 1 and fc.consumption_date = '2021-09-01'
//    group by nutrient.id, fn.id, fc.id
//
//              ) as subresult group by subresult.nutrient_id2;
//

}
