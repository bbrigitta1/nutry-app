package com.example.nutry.model;

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

    private Long foodId;

    private Long nutrientId;

    private double value;


}
