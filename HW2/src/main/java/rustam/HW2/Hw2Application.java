package rustam.HW2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw2Application {

	public static void main(String[] args) {

		SpringApplication.run(Hw2Application.class, args);

		StudentController studentController = new StudentController();

		// Примеры использования методов контроллера
		System.out.println("Student with ID 3: " + studentController.getStudentById(3));
		System.out.println("All Students:");
		studentController.getAllStudents().forEach(System.out::println);
		System.out.println("Students with 'Student' in name:");
		studentController.searchStudentsByName("Student").forEach(System.out::println);
		System.out.println("Students in Group2:");
		studentController.getStudentsByGroup("Group2").forEach(System.out::println);
	}



}
