package com.example.rest_crud.controller;

import com.example.rest_crud.dto.StudentErrorResponse;
import com.example.rest_crud.entity.Student;
import com.example.rest_crud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException error) {
        var status = HttpStatus.NOT_FOUND;
        var response = new StudentErrorResponse(status, error.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception error) {
        var status = HttpStatus.BAD_REQUEST;
        var response = new StudentErrorResponse(status, error.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, status);
    }
}
