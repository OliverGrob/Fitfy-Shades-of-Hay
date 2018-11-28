package com.codecool.enterprise.avatar.controller;

import com.codecool.enterprise.avatar.model.Workout;
import com.codecool.enterprise.avatar.repository.WorkoutRepository;
import com.codecool.enterprise.avatar.service.WorkoutService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
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
