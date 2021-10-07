package com.example.nutry.service;

import com.example.nutry.model.FoodConsumed;
import com.example.nutry.repository.FoodConsumedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodConsumedService implements IFoodConsumedService{
    @Autowired
    private FoodConsumedRepository foodConsumedRepository;

    @Override
    public void save(FoodConsumed foodConsumed) {
        foodConsumedRepository.save(foodConsumed);
    }

    @Override
    public List<FoodConsumed> findAll() {
        return foodConsumedRepository.findAll();
    }
}
