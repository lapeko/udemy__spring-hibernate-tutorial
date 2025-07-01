package com.example.mysql_jpa.dao;

import com.example.mysql_jpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student getById(int id);
    List<Student> getAll();
    List<Student> getByLastName(String lastName);
    void update(Student student);
}
