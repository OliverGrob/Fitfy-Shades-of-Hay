package com.codecool.nutrition_calculator.respository;

import com.codecool.nutrition_calculator.model.NutritionData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NutritionRepository extends JpaRepository<NutritionData, Long> {

    List<NutritionData> findByFoodName(String foodName);
}
