package com.example.nutry.repository;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import com.example.nutry.model.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriNutrientRepository extends JpaRepository <DriNutrient, Long> {

    List<DriNutrient> findAllByDriLifeStage(DriLifeStage driLifeStage);

    DriNutrient findDriNutrientByNutrientIdAndDriLifeStage(Long id, DriLifeStage stage);


}
