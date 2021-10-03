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

    @OneToMany(mappedBy = "nutrient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    List<FoodNutrient> foodNutrients;

}
