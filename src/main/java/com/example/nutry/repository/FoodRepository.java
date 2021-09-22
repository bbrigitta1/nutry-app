package com.example.nutry.repository;

import com.example.nutry.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//By extending from the Spring CrudRepository,
// we will have some methods for our data repository implemented,
// including findAll().
// This way we save a lot of boilerplate code.

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
}
