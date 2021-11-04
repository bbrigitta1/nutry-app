package com.example.nutry.service;

import com.example.nutry.model.FoodConsumed;
import com.example.nutry.model.Nutrient;

import java.util.List;

public interface IFoodConsumedService {
    void save(FoodConsumed foodConsumed);
    List<FoodConsumed> findAll();
}
