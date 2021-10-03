package com.example.nutry.service;

import com.example.nutry.model.Food;
import com.example.nutry.model.Nutrient;

import java.util.List;

public interface INutrientService {
    List<Nutrient> findAll();
    void save(Nutrient nutrient);
    Nutrient getByNutrientId2(Long nutrientId);



}
