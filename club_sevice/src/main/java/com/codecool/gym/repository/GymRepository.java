package com.codecool.gym.repository;

import com.codecool.gym.model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GymRepository extends JpaRepository<Gym, Long> {

    List<Gym> findByNameContainingIgnoreCase(String substring);
}
