package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @Value("${staticdata.name}")
    private String name;

    @Value("${staticdata.group}")
    private String group;

    @GetMapping("/")
    public String printHello() {
        return String.format("<h1>Hello %s! Group: %s</h1>", name, group);
    }
}
