package com.codecool.enterprise.workout.controller;

import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Training;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.service.WorkoutService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
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
    public void saveWorkout(@RequestBody String jsonRequest) {
//        service.saveWorkout(jsonRequest);
    }

    @GetMapping("workout/exercises")
    public Exercise[] getExercises() {
        return Exercise.values();
    }
}
