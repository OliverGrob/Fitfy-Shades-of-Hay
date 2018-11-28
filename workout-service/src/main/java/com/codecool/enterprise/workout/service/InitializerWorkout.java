package com.codecool.enterprise.workout.service;

import com.codecool.enterprise.workout.model.Day;
import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitializerWorkout {

    @Autowired
    WorkoutRepository repository;

    public InitializerWorkout(WorkoutRepository repository) {
        repository.save(new Workout("name", "description", Arrays.asList(Exercise.PULLUP), Day.MONDAY));
        repository.save(new Workout("morning workout", "description2", Arrays.asList(Exercise.PULLUP), Day.FRIDAY));
    }
}
