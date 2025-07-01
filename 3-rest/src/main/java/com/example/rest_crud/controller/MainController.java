package com.example.rest_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MainController {
    @GetMapping("/great")
    public String greet() {
        return "Hi there";
    }
}
