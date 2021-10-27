package com.example.nutry.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="food_consumed")
public class FoodConsumed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private int amount;

    private LocalDate consumptionDate;


    @ManyToOne
    private Food food;

    @Override
    public String toString() {
        return "FoodConsumed{" +
                "id=" + id +
                ", amount=" + amount +
                ", consumptionDate=" + consumptionDate +
                //", food=" + food.getDescription() +
                '}';
    }
}
