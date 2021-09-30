package com.example.nutry.service;

import com.example.nutry.model.AddedFood;
import com.example.nutry.model.FoodConsumed;
import com.example.nutry.repository.FoodConsumedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodConsumedService implements IFoodConsumedService{
    @Autowired
    private FoodConsumedRepository foodConsumedRepository;

    @Override
    public void save(FoodConsumed foodConsumed) {
        foodConsumedRepository.save(foodConsumed);
    }
}
