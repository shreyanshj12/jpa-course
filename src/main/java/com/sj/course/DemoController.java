package com.sj.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private final Coach coach;

  @Autowired //optional bcz we've only 1 constructor
  public DemoController(final Coach coach) {
    this.coach = coach;
  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return this.coach.getDailyWorkout();
  }
}
