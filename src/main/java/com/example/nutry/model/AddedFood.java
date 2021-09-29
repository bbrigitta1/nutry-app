package com.example.nutry.model;

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
@Table(name = "addedfoods")
public class AddedFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Integer energy;
    private Integer amount;

//    @ElementCollection(fetch = FetchType.LAZY)
//    @CollectionTable(name="food_nutrients", joinColumns = @JoinColumn(name = "id"))
//    @AttributeOverrides({
//        @AttributeOverride(name = "nutrientName", column = @Column(name = "name")),
//        @AttributeOverride(name = "unitName", column = @Column(name = "unit")),
//        @AttributeOverride(name = "value", column = @Column(name = "value"))
//})

    @OneToMany(targetEntity = FoodNutrient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fn_fk", referencedColumnName = "id")
    private List<FoodNutrient> nutrients;

    @Override
    public String toString() {
        return "AddedFood{" +
                "description='" + description + '\'' +
                ", energy=" + energy +
                ", amount=" + amount +
                '}';
    }
}
