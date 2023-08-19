package com.sj.course.dao;

import com.sj.course.entity.Instructor;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public interface InstructorDao {
  void save(Instructor instructor);

  Instructor findInstructorById(UUID id);

  void deleteInstructorById(UUID id);
}
