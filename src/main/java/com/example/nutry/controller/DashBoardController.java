package com.example.nutry.controller;

import com.example.nutry.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping("/getMacroNutrients")
    private HashMap<String, Integer> getMacroNutrients() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1003", 90);
        map.put("1004", 10);
        map.put("1005", 50);
        return map;
    }
}
