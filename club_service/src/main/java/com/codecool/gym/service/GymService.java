package com.codecool.gym.service;

import com.codecool.gym.model.Gym;
import com.codecool.gym.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService {

    @Autowired
    GymRepository repository;

    public List<Gym> findGymByName(String substring) {
        return repository.findByNameContainingIgnoreCase(substring);
    }

    public List<Gym> findGymByDistrict(String district) {
        return repository.findAll().stream()
                .filter(gym -> gym.getZipCode().substring(1, 3).equals(district))
                .collect(Collectors.toList());
    }
}
