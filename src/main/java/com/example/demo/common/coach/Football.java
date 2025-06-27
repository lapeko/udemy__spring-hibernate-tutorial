package com.example.demo.common.coach;

import org.springframework.stereotype.Component;

@Component
public class Football implements Coach {
    @Override
    public String getDailyWorkout() {
        return "More food more power. Do you best in McDonald's. Eat like a champion!";
    }
}
