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

    @Column(name="description")
    private String description;

    public Food() {
    }

    public Food(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" +
                "description='" + description + '\'' +
                '}';
    }
}
