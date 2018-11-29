package com.codecool.enterprise.workout.controller;

import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void saveWorkout(@RequestBody String workout) {
        service.saveWorkout(workout);
    }

    @GetMapping("workout/exercises")
    public List<Exercise> getExercises() {
        return service.getExerciseList();
    }
}
