package com.codecool.gym.service;

import com.codecool.gym.model.Gym;
import com.codecool.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    GymRepository repository;

    public List<Gym> findGymByName(String substring) {
        return repository.findByNameContainingIgnoreCase(substring);
    }
}
