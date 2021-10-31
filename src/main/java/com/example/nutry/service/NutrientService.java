package com.example.nutry.service;

import com.example.nutry.model.Food;
import com.example.nutry.model.Nutrient;
import com.example.nutry.repository.NutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutrientService implements INutrientService{

    @Autowired
    private NutrientRepository nutrientRepository;

    @Override
    public List<Nutrient> findAll() {
        return nutrientRepository.findAll();
    }

    @Override
    public void save(Nutrient nutrient) {
        nutrientRepository.save(nutrient);
    }

    @Override
    public void saveAll(List<Nutrient> nutrientList) {
        nutrientRepository.saveAll(nutrientList);
    }

    @Override
    public Nutrient getByNutrientId2(Long nutrientId) {
        return nutrientRepository.findByNutrientId2(nutrientId);
    }

    public String getNutrientNameByNutrientId2 (Long nutrientId2) {
        return nutrientRepository.findNutrientByNutrientId2(nutrientId2).getNutrientName();
    }




}
