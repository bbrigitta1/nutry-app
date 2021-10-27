package com.example.nutry.service;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriNutrientService implements IDriNutrientService{

    @Autowired
    private DriNutrientService driNutrientRepository;

    @Override
    public List<DriNutrient> findAll() {
        return driNutrientRepository.findAll();
    }

    @Override
    public List<DriNutrient> findByLifeStage(DriLifeStage driLifeStage) {
        return driNutrientRepository.findByLifeStage(driLifeStage);
    }

    @Override
    public List<DriNutrient> findByGender(Double gender) {
        return driNutrientRepository.findByGender(gender);
    }





}
