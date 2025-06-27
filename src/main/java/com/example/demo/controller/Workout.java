package com.example.demo.controller;

import com.example.demo.common.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Workout {
    private Coach coach;

    @Autowired
    public void setCoach(@Qualifier("crazy") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
