package com.example.nutry.service;

import com.example.nutry.model.Food;

import java.util.List;

//IFoodService provides a contract method to get all cities from the data source.
public interface IFoodService {
    List<Food> findAll();
    Food save(Food food);
}
