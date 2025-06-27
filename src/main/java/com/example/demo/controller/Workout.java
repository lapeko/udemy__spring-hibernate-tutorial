package com.example.demo.controller;

import com.example.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Workout {
    private final Coach coach;

    @Autowired
    Workout(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
