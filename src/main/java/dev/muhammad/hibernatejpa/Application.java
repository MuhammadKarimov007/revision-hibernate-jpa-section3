package dev.muhammad.hibernatejpa;

import dev.muhammad.hibernatejpa.dao.StudentDAO;
import dev.muhammad.hibernatejpa.dao.StudentDAOImpl;
import dev.muhammad.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAOImpl studentDAOImpl) {
        return runner -> getUsersWithSpecificMail(studentDAOImpl);
    }

    public void createStudent(StudentDAOImpl studentDAOImpl) {
        Student student1 = new Student("David",
                "Cameron",
                "david@gmail.com");
        Student student2 = new Student("Andrew",
                "Ma",
                "andrew@somail.com");
        Student student3 = new Student("Bob",
                "Jackson",
                "bob@bob.com");
        Student student4 = new Student("Sarah",
                "Tyson",
                "sarah@mail.ru");
        Student student5 = new Student("Ma",
                "Long",
                "ma@reaction.com");

        studentDAOImpl.save(student1);
        studentDAOImpl.save(student2);
        studentDAOImpl.save(student3);
        studentDAOImpl.save(student4);
        studentDAOImpl.save(student5);
    }

    public void findStudent(StudentDAOImpl studentDAO) {
        System.out.println(studentDAO.findById(1));
    }

    public void searchByLastName(StudentDAOImpl studentDAO) {
        List<Student> studentList = studentDAO.findByLastName("Karimov");
        studentList.forEach(System.out::println);
    }

    public void getGmailUsers(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findStudentsWithGmail();
        students.forEach(System.out::println);
    }

    public void getUsersWithSpecificMail(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findStudentsWithSpecificMail("bob@bob.com");

        students.forEach(System.out::println);
    }

    public void removeAll(StudentDAOImpl studentDAO) {
        studentDAO.deleteAll();
    }
}
