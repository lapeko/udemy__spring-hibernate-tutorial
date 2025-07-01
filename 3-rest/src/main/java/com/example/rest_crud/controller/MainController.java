package com.example.rest_crud.controller;

import com.example.rest_crud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class MainController {
    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        var students = new ArrayList<Student>();
        students.add(new Student("Mickey", "Mouse"));
        students.add(new Student("Tom", "Tom"));
        return students;
    }
}
