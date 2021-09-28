package com.example.nutry.service;

import com.example.nutry.model.AddedFood;

import java.util.List;

//IFoodService provides a contract method to get all cities from the data source.
public interface IAddedFoodService {
    List<AddedFood> findAll();
    void save(AddedFood addedFood);
    //public Object save(Object entity);

   // <S extends T> S save(S var1);
}
