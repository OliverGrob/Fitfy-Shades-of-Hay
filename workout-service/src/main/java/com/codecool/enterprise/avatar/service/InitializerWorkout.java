package com.codecool.enterprise.avatar.service;

import com.codecool.enterprise.avatar.model.Day;
import com.codecool.enterprise.avatar.model.Exercise;
import com.codecool.enterprise.avatar.model.Workout;
import com.codecool.enterprise.avatar.repository.WorkoutRepository;
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
