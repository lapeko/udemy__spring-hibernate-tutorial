package com.example.demo.lib.more_coaches;

import com.example.demo.common.coach.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoreCoaches {

    @Bean("crazy")
    public Coach CrazyCoach() {
        return new Crazy();
    }
}
