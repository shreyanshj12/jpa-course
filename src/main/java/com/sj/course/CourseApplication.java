package com.sj.course;

import com.sj.course.dao.InstructorDao;
import com.sj.course.entity.Instructor;
import com.sj.course.entity.InstructorDetail;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class CourseApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourseApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(InstructorDao instructorDao) {
    return runner -> {
      //createInstructor(instructorDao);
      getInstructorDetails(instructorDao);
      deleteInstructorById(instructorDao);
    };
  }

  private void createInstructor(InstructorDao instructorDao) {
    // create the Instructor object
    log.info("Creating new Instructor");

    final InstructorDetail instructorDetail = InstructorDetail.builder()
        .youtubeChannel("mavChannel")
        .hobby("teaches flying")
        .build();

    final Instructor instructor = Instructor.builder()
        .firstName("Pete")
        .lastName("Maverick")
        .emailAddress("pete@maverick.com")
        .instructorDetail(instructorDetail)
        .build();

    // save the Instructor object
    System.out.println("Saving the new Instructor");

    //saves both instructor and instructorDetail as we've CascadeType.ALL
    instructorDao.save(instructor);
    // display id of the saved Instructor object
    System.out.println("Saved Instructor successfully. ID: " + instructor.getId());
  }

  private void getInstructorDetails(final InstructorDao instructorDao) {
    //fetches both instructor and instructorDetail bcz CASCADE TYPE. ALL
    final UUID id = UUID.fromString("de9f64c2-5363-4e0c-aacc-e9c35e54a92b");
    final Instructor retrievedInstructor = instructorDao.findInstructorById(id);
    log.info("Retrieved instructor email: {}", retrievedInstructor.getEmailAddress());
  }

  private void deleteInstructorById(final InstructorDao instructorDao) {
    final UUID id = UUID.fromString("de9f64c2-5363-4e0c-aacc-e9c35e54a92b");
    //deletes both instructor and instructorDetail bcz CASCADE TYPE. ALL
    instructorDao.deleteInstructorById(id);
  }
}
