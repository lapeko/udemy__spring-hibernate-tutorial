package com.example.mysql_jpa.dao;

import com.example.mysql_jpa.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return entityManager
                .createQuery("from Student order by lastName", Student.class)
                .getResultList();
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        return entityManager
                .createQuery("select s from Student s where s.lastName=:lName", Student.class)
                .setParameter("lName", lastName)
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager
                .createQuery("DELETE FROM Student s where s.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager
                .createQuery("DELETE FROM Student")
                .executeUpdate();
    }
}
