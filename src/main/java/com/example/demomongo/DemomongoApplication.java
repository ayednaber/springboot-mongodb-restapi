package com.example.demomongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemomongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemomongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
					"England",
					"London",
					"NW9"
			);
			Student student = new Student(
					"Ayed",
					"Naber",
					"naberayed@gmail.com",
					Gender.MALE,
					address,
					List.of("Computer Science"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
			String email = "naberayed@gmail.com";

			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println(s + " already exists");
					}, () -> {
						System.out.println("Inserting student " + student);
						repository.insert(student);
					});

			// Instead of all this logic, we can use our newly defined method in our repository
//			Query query = new Query();
//			query.addCriteria(Criteria.where("email").is(email));
//
//			List<Student> students = mongoTemplate.find(query, Student.class);
//
//			if (students.size() > 1) {
//				throw new IllegalStateException("Found many students with email " + email);
//			}
//
//			if (students.isEmpty()) {
//				System.out.println("Inserting student " + student);
//				repository.insert(student);
//			} else {
//				System.out.println(student + " already exists");
//			}


		};
	}

}
