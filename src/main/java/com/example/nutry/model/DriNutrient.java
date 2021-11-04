package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "dri_nutrient")
public class DriNutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double recommended;

    @ManyToOne(cascade = {CascadeType.ALL})
    private DriLifeStage driLifeStage;

    @ManyToOne
    private Nutrient nutrient;




}
