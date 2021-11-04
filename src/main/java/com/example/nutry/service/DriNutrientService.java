package com.example.nutry.service;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import com.example.nutry.model.Nutrient;
import com.example.nutry.repository.DriNutrientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriNutrientService implements IDriNutrientService{

    @Autowired
    private DriNutrientRepository driNutrientRepository;


    @Override
    public List<DriNutrient> findAllByLifeStage(DriLifeStage driLifeStage) {
        return driNutrientRepository.findAllByDriLifeStage(driLifeStage);
    }

    @Override
    public Optional<DriNutrient> getById(Long id) {
        return null;
    }

    @Override
    public DriNutrient getByNutrientIdAndLifeStage(Long id, DriLifeStage stage) {
        return driNutrientRepository.findDriNutrientByNutrientIdAndDriLifeStage(id, stage);
    }







}
