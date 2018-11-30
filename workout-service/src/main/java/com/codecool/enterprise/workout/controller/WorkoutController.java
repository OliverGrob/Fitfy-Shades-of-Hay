package com.codecool.enterprise.workout.controller;

import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.service.WorkoutService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WorkoutController {

    @Autowired
    WorkoutService service;


    @GetMapping("/workout")
    public List<Workout> getWorkouts() {
        List<Workout> workouts = service.getAllWorkouts();
        return workouts;
    }

    @PostMapping("/workout")
    public void saveWorkout(@RequestBody Map<String, String> workout) {
        System.out.println(workout);
        service.saveWorkout(workout);
    }

    @GetMapping("workout/exercises")
    public String getExercises() {
        JsonArray jsonArray = new JsonArray();
        for (Exercise exercise : service.getExerciseList()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", 4);
            jsonObject.addProperty("name", exercise.toString());
            jsonObject.addProperty("repetition", 30);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
