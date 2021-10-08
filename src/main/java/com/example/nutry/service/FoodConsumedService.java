package com.example.nutry.service;

import com.example.nutry.model.FoodConsumed;
import com.example.nutry.model.User;
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

    public List<FoodConsumed> findByUser (User user){
        return foodConsumedRepository.findByUser(user);
    }

    public void changeFoodAmount(Long consumedFoodId, Integer amount){
        FoodConsumed foodConsumed = foodConsumedRepository.getById(consumedFoodId);
        Integer newAmount = foodConsumed.getAmount() + amount;
        foodConsumed.setAmount(newAmount);
        foodConsumedRepository.save(foodConsumed);

    }

    public void deleteFood (Long consumedFoodId){
        foodConsumedRepository.deleteById(consumedFoodId);
    }


}
