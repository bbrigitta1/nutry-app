package com.example.nutry.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MacroNutrientsDTO {

    private Double protein;
    private Double fat;
    private Double carbohydrate;
}
