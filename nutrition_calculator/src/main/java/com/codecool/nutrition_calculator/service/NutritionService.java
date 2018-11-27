package com.codecool.nutrition_calculator.service;

import com.codecool.nutrition_calculator.model.Foods;
import com.codecool.nutrition_calculator.model.NutritionData;
import com.codecool.nutrition_calculator.respository.NutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NutritionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NutritionRepository nutritionRepository;

    @Value("${nutritionURL}")
    private String nutritionURL;

    public List<NutritionData> getNutritionData() {

        String json = "{\"query\":\"for breakfast i ate 2 eggs, bacon, and french toast\", \"timezone\": \"US/Eastern\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("x-app-id", "28d99821");
        headers.set("x-app-key", "4394ea6d29720b1901b61abb346c733c");
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        List<NutritionData> response = restTemplate.exchange(
                nutritionURL, HttpMethod.POST, entity, Foods.class).getBody().getFoods();
        response.forEach(nutritionData -> nutritionRepository.save(nutritionData));
        return response;
    }
}
