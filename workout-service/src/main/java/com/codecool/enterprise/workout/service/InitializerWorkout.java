package com.codecool.enterprise.workout.service;

import com.codecool.enterprise.workout.model.Day;
import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.User;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitializerWorkout {

    @Autowired
    WorkoutRepository repository;

    public InitializerWorkout(WorkoutRepository repository) {

        Workout workout1 = new Workout("name", "description", Arrays.asList(Exercise.PULLUPS), Day.MONDAY);
        Workout workout2 = new Workout("morning workout", "description2", Arrays.asList(Exercise.PULLUPS), Day.FRIDAY);
        List<Workout> workouts = Arrays.asList(workout1, workout2);
        repository.save(workout1);
        repository.save(workout2);
    }
}
