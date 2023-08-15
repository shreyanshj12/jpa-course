package com.sj.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //enables auto-configuration, component scanning, additional configuration
public class CourseApplication {

  public static void main(String[] args) {
    SpringApplication.run(CourseApplication.class, args);
  }
}
