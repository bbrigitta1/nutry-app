package com.example.nutry.service;

import com.example.nutry.model.AddedFood;
import com.example.nutry.model.Food;

import java.util.List;

//IFoodService provides a contract method to get all cities from the data source.
public interface IFoodService {
    List<Food> findAll();
    void save(Food food);
    //public Object save(Object entity);

   // <S extends T> S save(S var1);
}
