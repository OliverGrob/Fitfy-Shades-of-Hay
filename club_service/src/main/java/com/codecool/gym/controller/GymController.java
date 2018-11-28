package com.codecool.gym.controller;

import com.codecool.gym.model.Gym;
import com.codecool.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    GymService service;

    @GetMapping("/search")
    public List<Gym> getGymByName(@RequestParam("gym") String substring) {
        return service.findGymByName(substring);
    }

}
