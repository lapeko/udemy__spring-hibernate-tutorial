package com.example.mysql_jpa;

import com.example.mysql_jpa.dao.StudentDAO;
import com.example.mysql_jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MysqlJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			saveStudent(studentDAO);
		};
	}

	private void saveStudent(StudentDAO studentDAO) {
		var tempStudent = new Student("Jefstafiy", "Gd", "gd@mail.com");

		System.out.printf("Saving a user: %s%n", tempStudent);
		studentDAO.save(tempStudent);

		System.out.printf("User: %s successfully saved%n", tempStudent);

		var foundStudent = studentDAO.getById(2);

		System.out.printf("Found user with id 1: %s%n", foundStudent);

		var allStudents = studentDAO.getAll();

		System.out.println("All users:");
		for (Student s: allStudents) {
			System.out.println(s);
		}

		var lastName = "Gd";
		var gd = studentDAO.getByLastName(lastName);
		System.out.printf("Found user with lastName: %s is %s", lastName, gd);
	}
}
