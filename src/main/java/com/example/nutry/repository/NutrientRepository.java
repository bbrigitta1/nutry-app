package com.example.nutry.repository;

import com.example.nutry.model.Food;
import com.example.nutry.model.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutrientRepository extends JpaRepository<Nutrient, Long> {


}
