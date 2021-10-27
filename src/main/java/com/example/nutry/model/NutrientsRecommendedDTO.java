package com.example.nutry.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NutrientsRecommendedDTO {

    private Long nutrientId2;

    private String nutrientName;
    private String unitName;
    private String category;
    private Double recommended;

}
