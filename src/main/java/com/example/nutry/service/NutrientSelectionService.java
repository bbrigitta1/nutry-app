package com.example.nutry.service;

import com.example.nutry.model.NutrientSelection;
import com.example.nutry.model.User;
import com.example.nutry.repository.NutrientSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutrientSelectionService implements INutrientSelection {

    @Autowired
    private NutrientSelectionRepository selectedNutrientRepository;



    @Override
    public void save(NutrientSelection nutrientSelection) {
        selectedNutrientRepository.save(nutrientSelection);
    }

    public void deleteByUser(User user) {
        selectedNutrientRepository.deleteById(selectedNutrientRepository.findNutrientSelectionByUser(user).getId());
        }


    public NutrientSelection findNutrientSelectionByUser(User user){
        return selectedNutrientRepository.findNutrientSelectionByUser(user);
    }

}
