package com.example.nutry.repository;

import com.example.nutry.model.DriLifeStage;
import com.example.nutry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriLifeStageRepository extends JpaRepository <DriLifeStage, Long> {



}
