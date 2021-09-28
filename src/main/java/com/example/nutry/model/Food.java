package com.example.nutry.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Integer energy;
    private Integer amount;

    public Food() {
    }

    public Food(String description, Integer energy, Integer amount) {
        this.description = description;
        this.energy = energy;
        this.amount = amount;
    }

    public Food(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", energy=" + energy +
                ", amount=" + amount +
                '}';
    }
}
