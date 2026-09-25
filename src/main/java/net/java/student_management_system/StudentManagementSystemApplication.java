package net.java.student_management_system;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Main class for starting the Student Management System application.
 */
@SpringBootApplication
public class StudentManagementSystemApplication {

	/**
	 * Creates the ModelMapper bean used for converting between entities and DTOs.
	 * @return the configured ModelMapper instance
	 */
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}
