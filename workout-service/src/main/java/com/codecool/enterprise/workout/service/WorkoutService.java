package com.codecool.enterprise.workout.service;


import com.codecool.enterprise.workout.model.Day;
import com.codecool.enterprise.workout.model.Exercise;
import com.codecool.enterprise.workout.model.Training;
import com.codecool.enterprise.workout.model.Workout;
import com.codecool.enterprise.workout.repository.WorkoutRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository repository;

    public List<Workout> getAllWorkouts() {
        return this.repository.findAll();
    }

    public void saveWorkout(String workout) {
        JSONObject jsonObject = new JSONObject(workout);
        String name = jsonObject.get("name").toString();
        String description = jsonObject.get("description").toString();
        List<Training> trainings = new ArrayList<>();
        JSONArray trainingArray = jsonObject.getJSONArray("trainings");

        for (int i = 0; i < trainingArray.length(); i++) {
            JSONObject training = trainingArray.getJSONObject(i);
            trainings.add(new Training(Exercise.valueOf(String.valueOf(training.get("name"))), Integer.parseInt(String.valueOf(training.get("repetition")))));
        }

        Day day = Day.valueOf((String) jsonObject.get("day"));

        Workout newWorkout = new Workout(name, description, trainings, day);

        repository.save(newWorkout);
    }

    public List<Exercise> getExerciseList() {
        return Arrays.asList(Exercise.values());
    }
}
