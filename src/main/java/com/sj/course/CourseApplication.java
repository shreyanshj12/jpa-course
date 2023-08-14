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
      //createStudent(studentDao);
      getStudentById(studentDao, UUID.fromString("c090c32f-cf19-49d0-a651-ae34d20154a4"));
      getAllStudents(studentDao);
      getStudentsByLastName(studentDao, "Doe");
      updateStudentUsingJpa(studentDao);
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

  private void updateStudentUsingJpa(StudentDao studentDao) {
    //find the student to update
    final Student getStudent = getStudentById(
        studentDao,
        UUID.fromString("c090c32f-cf19-49d0-a651-ae34d20154a4")
    );

    //change last name
    getStudent.setLastName("Walker");

    //update student
    studentDao.updateUsingJpa(getStudent);
  }
}
