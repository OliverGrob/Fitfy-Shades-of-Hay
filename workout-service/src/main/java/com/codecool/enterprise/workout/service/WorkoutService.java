package com.codecool.enterprise.workout.service;


import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository repository;

    public List<Workout> getAllWorkouts() {
        return this.repository.findAll();
    }
}
