package com.sj.course.dao;

import com.sj.course.entity.Instructor;
import jakarta.persistence.EntityManager;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstructorDaoImpl implements InstructorDao {

  //define field for entity manager
  private final EntityManager entityManager;

  // inject entity manager using constructor injection
  @Autowired
  public InstructorDaoImpl(final EntityManager em) {
    this.entityManager = em;
  }

  @Override
  @Transactional
  public void save(final Instructor instructor) {
    //this will also save InstructorDetail object bcz we've CascadeType.ALL
    entityManager.persist(instructor);
  }

  @Override
  public Instructor findInstructorById(UUID id) {
    return entityManager.find(Instructor.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorById(UUID id) {
    final Instructor fetchInstructorToDelete = entityManager.find(Instructor.class, id);
    entityManager.remove(fetchInstructorToDelete);
  }


}
