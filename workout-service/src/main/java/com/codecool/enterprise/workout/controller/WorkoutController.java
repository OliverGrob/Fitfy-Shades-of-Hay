package com.codecool.enterprise.workout.controller;

import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {

    @Autowired
    WorkoutService service;


    @GetMapping("/workout")
    public List<Workout> getWorkouts() {
        List<Workout> workouts = service.getAllWorkouts();
        System.out.println(workouts.get(0).getName());
        return workouts;
    }
}
