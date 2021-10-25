package com.example.nutry.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NutrientsDTO {

    private Double protein;
    private Double fat;
    private Double carbohydrate;
    private Double energy;

    private Double sugar;
    private Double fiber;

    private Double calcium;
    private Double copper;
    private Double iron;
    private Double magnesium;
    private Double phosphorus;
    private Double potassium;
    private Double selenium;
    private Double sodium;
    private Double zinc;

    private Double vitaminA;
    private Double vitaminD;
    private Double vitaminE;
    private Double vitaminEAdded;
    private Double vitaminK;
    private Double vitaminC;
    private Double vitaminB1Thiamin;
    private Double vitaminB2Riboflavin;
    private Double vitaminB3Niacin;
    private Double vitaminB6Pyridoxine;
    private Double vitaminB12Cobalmid;
    private Double vitaminB12Added;

    private Double retinol;
    private Double betaCarotene;
    private Double alphaCarotene;
    private Double lycopene;
    private Double luteinZeaxanthin;
    private Double folate;
    private Double choline;
    private Double folicAcid;
    private Double cholesterol;
    private Double fattyAcidsSaturated;
    private Double fattyAcidsMonounsaturated;
    private Double fattyAcidsTotalPolyunsaturated;

}
