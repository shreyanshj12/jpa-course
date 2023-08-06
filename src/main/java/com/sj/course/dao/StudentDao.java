package com.sj.course.dao;

import com.sj.course.entity.Student;
import java.util.List;
import java.util.UUID;

public interface StudentDao {
  void save(Student student);

  Student findById(UUID id);

  List<Student> findAll();

  List<Student> findByLastName(String lastName);

  void updateUsingJpa(Student student);

  void deleteStudent(UUID id);
}
