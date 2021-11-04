package com.example.nutry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashBoardRepository {


    @Query("SELECT distinct s.address.country from Student s")
    List<String> getMacroNutrientsConsumedForDate();
}
