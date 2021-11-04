package com.example.nutry.service;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.DriNutrient;
import com.example.nutry.repository.DriLifeStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriLifeStageService implements IDriLifeStageService {

    @Autowired
    private DriLifeStageRepository driLifeStageRepository;

    @Override
    public DriLifeStage findByGender (Double gender) {
        return driLifeStageRepository.findByGender(gender);
    }


}


