package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FoodDTO {



    private Long fdcId;
    private String description;
    private Integer energy;
    private LocalDate date;

    private List<FoodConsumed> foodConsumed;


    private List<FoodNutrient> foodNutrients;

    @Override
    public String toString() {
        return "FoodDTO{" +
                "fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", energy=" + energy +
                ", foodConsumed=" + foodConsumed +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}
