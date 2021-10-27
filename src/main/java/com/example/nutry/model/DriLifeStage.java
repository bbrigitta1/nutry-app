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
public class DriLifeStage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double gender;
    private String stageType;
    private Integer ageFrom;
    private Integer ageTo;

//    @OneToMany( mappedBy= "driLifeStage", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    @EqualsAndHashCode.Exclude
//    private List<DriNutrient> driNutrient;


//    @OneToMany(mappedBy = "driLifeStage", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    @EqualsAndHashCode.Exclude
//    private List<DriLifeStageNutrient> driLifeStageNutrients;

    @OneToMany(mappedBy = "driLifeStage", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<DriNutrient> driNutrients;



}
