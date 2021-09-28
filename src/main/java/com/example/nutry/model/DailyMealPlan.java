package com.example.nutry.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dailymealplan")
public class DailyMealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long foodId;
    private Integer amount;
    private LocalDate date;
    private Integer recommendedCalories;


}
