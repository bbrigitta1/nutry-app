package com.example.nutry.repository;

import com.example.nutry.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//By extending from the Spring CrudRepository,
// we will have some methods for our data repository implemented,
// including findAll().
// This way we save a lot of boilerplate code.

@Repository
public interface AddedFoodRepository extends JpaRepository<Food, Long> {
}
