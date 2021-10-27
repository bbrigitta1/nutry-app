package com.example.nutry.service;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import com.example.nutry.model.Nutrient;

import java.util.List;

public interface IDriNutrientService {
    List<DriNutrient> findAll();
    List<DriNutrient> findByLifeStage(DriLifeStage driLifeStage);
    List<DriNutrient> findByGender(Double gender)




}
