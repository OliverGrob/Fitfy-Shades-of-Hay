package com.codecool.enterprise.workout.service;

import com.codecool.enterprise.workout.model.Day;
import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Training;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.repository.TrainingRepository;
import com.codecool.enterprise.workout.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitializerWorkout {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    TrainingRepository trainingRepository;

    public InitializerWorkout(WorkoutRepository repository) {
        List<Training> training1 = new ArrayList<>();
        List<Training> training2 = new ArrayList<>();

        training1.add(new Training(Exercise.PULLUPS, 10));
        training1.add(new Training(Exercise.SQUATS, 10));
        training2.add(new Training(Exercise.CRUNCHES, 10));
        training2.add(new Training(Exercise.LUNGES, 10));

        repository.save(new Workout("name", "description", training1, Day.MONDAY));
        repository.save(new Workout("morning workout", "description2", training2, Day.FRIDAY));
    }
}
