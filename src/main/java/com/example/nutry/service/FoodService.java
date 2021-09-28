package com.example.nutry.service;

import com.example.nutry.model.Food;
import com.example.nutry.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//FoodService contains the implementation of the findAll() method.
// We use the repository to retrieve data from the database.

@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodRepository repository;

    @Override
    public List<Food> findAll() {
        //TODO check this var modifyer
        var foods = (List<Food>) repository.findAll();
        return foods;
    }

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }


}