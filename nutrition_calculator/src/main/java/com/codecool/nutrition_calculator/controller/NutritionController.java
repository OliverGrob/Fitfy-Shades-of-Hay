package com.codecool.nutrition_calculator.controller;

import com.codecool.nutrition_calculator.model.NutritionData;
import com.codecool.nutrition_calculator.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @PostMapping("/nutrition")
    public List<NutritionData> showNutritionData(@RequestBody Map<String, String> requestBody) {
        String serving = requestBody.get("serving");
        String meal = requestBody.get("meal");
        return nutritionService.getNutritionData(serving, meal);
    }

}
