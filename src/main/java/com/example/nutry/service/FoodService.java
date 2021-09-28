package com.example.nutry.service;

import com.example.nutry.model.AddedFood;
import com.example.nutry.model.Food;
import com.example.nutry.repository.AddedFoodRepository;
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
        return repository.findAll();
    }

    @Override
    public void save(Food food) {
        repository.save(food);
    }


}
