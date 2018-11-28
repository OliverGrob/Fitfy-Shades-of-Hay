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
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date date;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;


    @ElementCollection(targetClass = Exercise.class)
    @Enumerated(EnumType.STRING)
    private List<Exercise> exercises;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Day day;


    public Workout(String name, String description, List<Exercise> exercises, Day day) {
        this.name = name;
        this.description = description;
        this.exercises = exercises;
        this.day = day;
    }


}
