package com.example.rest_crud.controller;

import com.example.rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class MainController {
    private ArrayList<Student> students;

    @PostConstruct
    private void load() {
        students = new ArrayList<Student>();
        students.add(new Student("Mickey", "Mouse"));
        students.add(new Student("Thomas", "Jasper Cat Sr"));
        students.add(new Student("G.G. Goofy", "Goof"));
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return students.get(id);
    }
}
