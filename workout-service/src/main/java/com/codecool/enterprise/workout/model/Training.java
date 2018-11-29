package com.codecool.enterprise.workout.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Exercise name;

    @Column(nullable = false)
    private int repetition;

    public Training(Exercise name, int repetition) {
        this.name = name;
        this.repetition = repetition;
    }
}
