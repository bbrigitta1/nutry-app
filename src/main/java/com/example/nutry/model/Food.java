package com.example.nutry.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true, unique = true)
    private Long fdcId;
    private String description;
    private Integer energy;


    @OneToMany(mappedBy = "food", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<FoodConsumed> foodConsumed;


    @OneToMany(mappedBy = "food", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<FoodNutrient> foodNutrients;


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", fdcId=" + fdcId +
                ", description='" + description + '\'' +
                ", energy=" + energy +
                ", foodConsumed=" + foodConsumed +
                ", foodNutrients=" + foodNutrients +
                '}';
    }
}
