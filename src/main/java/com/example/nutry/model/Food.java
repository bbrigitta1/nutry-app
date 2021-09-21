package com.example.nutry.model;

public class Food {
    private String description;

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
