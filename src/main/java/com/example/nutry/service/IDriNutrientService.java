package com.example.nutry.service;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import com.example.nutry.model.Nutrient;

import java.util.List;
import java.util.Optional;

public interface IDriNutrientService {

    List<DriNutrient> findAllByLifeStage(DriLifeStage driLifeStage);
    Optional<DriNutrient> getById(Long id);
    DriNutrient getByNutrientIdAndLifeStage(Long id, DriLifeStage stage);





}
