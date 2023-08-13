package com.sj.course.dao;

import com.sj.course.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //helps with component scanning and translates JDBC exceptions
public class StudentDaoImpl implements StudentDao {

  //define field for entity manager
  private final EntityManager entityManager;

  //inject entity manager using constructor injection
  @Autowired  //autowired is optional if we've only one constructor
  public StudentDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  //implement save method
  @Override
  @Transactional
  public void save(Student student) {
    entityManager.persist(student);
  }

  @Override //no transactional annotation needed as we aren't doing any updates/modifications in db
  public Student findById(UUID id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  @Transactional
  public void updateUsingJpa(Student student) {
    entityManager.merge(student);
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
    return query.getResultList();
  }

  @Override
  public List<Student> findByLastName(final String lastName) {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theLastName", Student.class);
    query.setParameter("theLastName", lastName);
    return query.getResultList();
  }

  @Override
  @Transactional
  public void deleteStudent(final UUID id) {
    final Student student = entityManager.find(Student.class, id);
    entityManager.remove(student);

    /*
    can also delete based on condition
    TypedQuery<Student> query = entityManager
        .createQuery("DELETE FROM Student WHERE id=:studentId", Student.class)
        .setParameter("studentId", id);

    int deleted = query.executeUpdate();
     */
  }


}
