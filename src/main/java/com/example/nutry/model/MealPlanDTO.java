package com.example.nutry.model;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MealPlanDTO {

    private List<Food> foods;
    private MacroNutrientsDTO macroNutrients;


}
