package com.example.nutry.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MacroNutrientsDTO {

    private Integer protein;
    private Integer fat;
    private Integer carbohydrate;
}
