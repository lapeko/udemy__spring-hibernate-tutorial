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
			var allStudents = studentDAO.getAll();

			System.out.println("All users:");
			for (Student s: allStudents) {
				System.out.println(s);
			}
		};
	}
}
