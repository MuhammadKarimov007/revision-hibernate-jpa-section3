package dev.muhammad.hibernatejpa.dao;

import dev.muhammad.hibernatejpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    List<Student> findByLastName(String lastName);

    List<Student> findStudentsWithGmail();

    List<Student> findStudentsWithSpecificMail(String mailExtension);

    void update(Integer id, Student student);

    void deleteAll();
}
