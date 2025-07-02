package com.example.rest_crud.controller;

import com.example.rest_crud.entity.Student;
import com.example.rest_crud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class MainController {
    private ArrayList<Student> students;

    @PostConstruct
    private void load() {
        students = new ArrayList<>();
        students.add(new Student("Mickey", "Mouse"));
        students.add(new Student("Thomas", "Jasper Cat Sr"));
        students.add(new Student("G.G. Goofy", "Goof"));
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id < 0 || id >= students.size())
            throw new StudentNotFoundException(String.format("User with id %d not found", id));
        return students.get(id);
    }
}
