package com.example.nutry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addedfoods")
public class AddedFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer energy;
    private Integer amount;

    private int protein;
    private int proteinUnitName;
    private int fat;
    private int fatUnitName;
    private int carbohydrate;
    private int carbohydrateUnitName;
    private int sugars;
    private int sugarsUnitName;
    private int fiber;
    private int fiberUnitName;
    private int calcium;
    private int calciumUnitName;
    private int iron;
    private int ironUnitName;
    private int magnesium;
    private int magnesiumUnitName;
    private int phosphorus;
    private int phosphorusUnitName;
    private int potassium;
    private int potassiumUnitName;
    private int sodium;
    private int sodiumUnitName;
    private int zinc;
    private int zincUnitName;
    private int copper;
    private int copperUnitName;
    private int selenium;
    private int seleniumUnitName;
    private int retinol;
    private int retinolUnitName;
    private int vitaminA;
    private int vitaminAUnitName;
    private int caroteneBeta;
    private int caroteneBetaUnitName;
    private int caroteneAlpha;
    private int caroteneAlphaUnitName;
    private int vitaminE;
    private int vitaminEUnitName;
    private int vitaminD2plusD3;
    private int vitaminD2plusD3UnitName;
    private int cryptoxanthinBeta;
    private int cryptoxanthinBetaUnitName;
    private int lycopene;
    private int lycopeneUnitName;
    private int luteinPlusZeaxanthin;
    private int luteinPlusZeaxanthinUnitName;
    private int vitaminC;
    private int vitaminCUnitName;
    private int thiamin;
    private int thiaminUnitName;
    private int riboflavin;
    private int riboflavinUnitName;
    private int niacin;
    private int niacinUnitName;
    private int vitaminB6;
    private int vitaminB6UnitName;
    private int folate;
    private int folateUnitName;
    private int vitaminB12;
    private int vitaminB12UnitName;
    private int choline;
    private int cholineUnitName;
    private int vitaminK;
    private int vitaminKUnitName;
    private int folicAcid;
    private int folicAcidUnitName;
    private int folateFood;
    private int folateFoodUnitName;
    private int folateDfe;
    private int folateDfeUnitName;
    private int vitaminEadded;
    private int vitaminEaddedUnitName;
    private int vitamineB12Added;
    private int vitamineB12AddedUnitName;
    private int cholesterol;
    private int cholesterolUnitName;
    private int fattyAcidsSaturated;
    private int fattyAcidsSaturatedUnitName;
    private int fattyAcidsMonounsaturated;
    private int fattyAcidsMonounsaturatedUnitName;
    private int fattyAcidsPolyunsaturated;
    private int fattyAcidsPolyunsaturatedUnitName;



    @Override
    public String toString() {
        return "AddedFood{" +
                "description='" + description + '\'' +
                ", energy=" + energy +
                ", amount=" + amount +
                '}';
    }
}
