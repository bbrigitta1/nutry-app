package com.example.nutry.repository;

import com.example.nutry.model.DriNutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriNutrientRepository extends JpaRepository <DriNutrient, Long> {



}
