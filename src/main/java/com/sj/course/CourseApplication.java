package com.sj.course;

import com.sj.course.dao.StudentDao;
import com.sj.course.entity.Student;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourseApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDao studentDao) {
    return runner -> {
      final UUID id = UUID.fromString("2cd61cf1-5ab8-4069-a361-0ac4a2124723");
      //createStudent(studentDao);
      getStudentById(studentDao, id);
      getAllStudents(studentDao);
      getStudentsByLastName(studentDao, "Doe");
      updateStudentUsingJpa(studentDao, id);
    };
  }

  private void createStudent(StudentDao studentDao) {
    // create the student object
    System.out.println("Creating new student");
    final Student student = Student.builder()
        .firstName("Paul")
        .lastName("Doe")
        .email("paul@doe.com")
        .build();

    // save the student object
    System.out.println("Saving the new student");
    studentDao.save(student);

    // display id of the saved student object
    System.out.println("Saved student successfully. ID: " + student.getId());
  }

  private Student getStudentById(StudentDao studentDao, final UUID id) {
    final Student retrievedStudent = studentDao.findById(id);
    System.out.println(retrievedStudent.getEmail());
    return retrievedStudent;
  }

  private List<Student> getAllStudents(StudentDao studentDao) {
    return studentDao.findAll();
  }

  private List<Student> getStudentsByLastName(StudentDao studentDao, String lastName) {
    return studentDao.findByLastName(lastName);
  }

  private void updateStudentUsingJpa(StudentDao studentDao, final UUID id) {
    //find the student to update
    final Student getStudent = getStudentById(
        studentDao,
        id
    );

    //change last name
    getStudent.setLastName("Walker");

    //update student
    studentDao.updateUsingJpa(getStudent);
  }
}
