package com.example.nutry.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

    private String nutrientName;
    private String unitName;


}
