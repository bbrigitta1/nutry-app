package com.example.nutry.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MicroNutrientDTO {

    private String nutrientName;
    private Double amount;
}
