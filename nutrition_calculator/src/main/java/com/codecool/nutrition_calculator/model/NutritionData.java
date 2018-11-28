package com.codecool.nutrition_calculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NutritionData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("food_name")
    private String foodName;

    @JsonProperty("serving_qty")
    private int servingQuantity;

    @JsonProperty("serving_weight_grams")
    private int servingWeight;

    @JsonProperty("nf_calories")
    private int calories;

    @JsonProperty("nf_total_fat")
    private double totalFat;

    @JsonProperty("nf_saturated_fat")
    private double saturatedFat;

    @JsonProperty("nf_cholesterol")
    private double cholesterol;

    @JsonProperty("nf_sodium")
    private double sodium;

    @JsonProperty("nf_total_carbohydrate")
    private double totalCarbohydrate;

    @JsonProperty("nf_dietary_fiber")
    private double fiber;

    @JsonProperty("nf_sugars")
    private double sugar;

    @JsonProperty("nf_protein")
    private double protein;

    @JsonProperty("nf_potassium")
    private double potassium;

}
