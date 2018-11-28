package com.codecool.enterprise.avatar.repository;

import com.codecool.enterprise.avatar.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
