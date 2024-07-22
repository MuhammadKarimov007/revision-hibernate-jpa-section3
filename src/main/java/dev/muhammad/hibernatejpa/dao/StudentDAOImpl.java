package dev.muhammad.hibernatejpa.dao;

import dev.muhammad.hibernatejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(
                "from Student where lastName=:lastName", Student.class
        );

        studentTypedQuery.setParameter("lastName", lastName);

        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> findStudentsWithGmail() {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s where s.email like '%gmail.com'",
                Student.class
        );

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsWithSpecificMail(String mailExtension) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s where s.email=:extension",
                Student.class
        );
        query.setParameter("extension", mailExtension);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Integer id, Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student ").executeUpdate();
    }
}
