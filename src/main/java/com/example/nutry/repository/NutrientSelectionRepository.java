package com.example.nutry.repository;

import com.example.nutry.model.NutrientSelection;
import com.example.nutry.model.SelectedNutrientListDTO;
import com.example.nutry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutrientSelectionRepository extends JpaRepository <NutrientSelection, Long> {

    NutrientSelection findNutrientSelectionByUser(User user);

}
