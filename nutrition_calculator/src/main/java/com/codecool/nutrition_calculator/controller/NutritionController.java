package com.codecool.nutrition_calculator.controller;

import com.codecool.nutrition_calculator.model.NutritionData;
import com.codecool.nutrition_calculator.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/nutrition")
    public List<NutritionData> showNutritionData() {
        return nutritionService.getNutritionData();
    }
}
