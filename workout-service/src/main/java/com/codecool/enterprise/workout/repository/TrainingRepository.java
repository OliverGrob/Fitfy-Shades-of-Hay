package com.codecool.enterprise.workout.repository;

import com.codecool.enterprise.workout.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Workout, Long> {
}
