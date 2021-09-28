package com.example.nutry.model;

import javax.persistence.*;


@Entity
@Table(name = "addedfoods")
public class AddedFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Integer energy;
    private Integer amount;

    public String getDescription() {
        return description;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getAmount() {
        return amount;
    }

    public AddedFood() {
    }

    @Override
    public String toString() {
        return "AddedFood{" +
                "description='" + description + '\'' +
                ", energy=" + energy +
                ", amount=" + amount +
                '}';
    }
}
