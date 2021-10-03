package com.example.nutry.model;


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

    //TODO
//    @ManyToOne
//    private Long userId;

    //private Long foodId;

    private int amount;

    private LocalDate consumptionDate;


    @ManyToOne
    private Food food;




}
