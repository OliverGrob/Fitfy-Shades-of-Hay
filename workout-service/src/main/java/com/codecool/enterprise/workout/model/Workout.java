package com.codecool.enterprise.workout.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;


//    @ElementCollection
//    @CollectionTable(name = "exercise")
//    @MapKeyColumn(name = "exercise_col")
//    @MapKeyEnumerated(EnumType.STRING)
//    @Column(name = "repetition_col")
//    private Map<Exercise, Integer> exercises = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(nullable = false)
    @ToString.Exclude
    @JsonManagedReference
    private List<Training> trainings = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Day day;

    public Workout(String name, String description, List<Training> trainings, Day day) {
        this.name = name;
        this.description = description;
        this.trainings = trainings;
        this.day = day;
    }


}
