package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long nutrientId2;

    private String nutrientName;
    private String unitName;
    private String category;

    @OneToMany(mappedBy = "nutrient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    List<FoodNutrient> foodNutrients;

    @OneToMany(mappedBy = "nutrient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<DriNutrient> driNutrients;

    @Override
    public String toString() {
        return "Nutrient{" +
                "id=" + id +
                ", nutrientId2=" + nutrientId2 +
                ", nutrientName='" + nutrientName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}
