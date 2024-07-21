package dev.muhammad.hibernatejpa;

import dev.muhammad.hibernatejpa.dao.StudentDAOImpl;
import dev.muhammad.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAOImpl) {
        return runner -> createStudent(studentDAOImpl);
    }

    public void createStudent(StudentDAOImpl studentDAOImpl) {
        Student student = new Student("Shermukhammad",
                "Karimov",
                "karimov@gmail.com");

        studentDAOImpl.save(student);
    }
}
