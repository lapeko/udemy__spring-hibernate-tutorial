package com.example.demo.common.coach;

import org.springframework.stereotype.Component;

@Component
public class Cricket implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Sleep for all day today Champion!!!";
    }
}
