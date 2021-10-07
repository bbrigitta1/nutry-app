package com.example.nutry.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class FoodNutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private Long foodId;

    @JsonProperty(value = "nutrientId")
    private Long nutrientId2;

    private double value;


    @ManyToOne
    private Food food;

    @ManyToOne
    private Nutrient nutrient;

    @Override
    public String toString() {
        return "FoodNutrient{" +
                "id=" + id +
                ", nutrientId2=" + nutrientId2 +
                ", value=" + value +
                ", food=" + food.getDescription() +
//                ", nutrient=" + nutrient.getNutrientName() +
                '}';
    }
}
