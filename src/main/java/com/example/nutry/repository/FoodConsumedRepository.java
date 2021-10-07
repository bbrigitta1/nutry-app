package com.example.nutry.repository;

import com.example.nutry.model.FoodConsumed;
import com.example.nutry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FoodConsumedRepository extends JpaRepository<FoodConsumed, Long> {

    @Transactional
    List<FoodConsumed> findByUser(User user);



}
