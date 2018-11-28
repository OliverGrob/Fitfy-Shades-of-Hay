package com.codecool.enterprise.workout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int weight;

    @ElementCollection(targetClass = Workout.class)
    private List<Workout> workouts;

    public User(String name, int height, int weight, List<Workout> workouts) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.workouts = workouts;
    }
}
