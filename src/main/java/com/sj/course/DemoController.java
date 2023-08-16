package com.sj.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  //Constructor injection example
  private final Coach coach;

  @Autowired //optional bcz we've only 1 constructor
  public DemoController(@Qualifier("runningCoach") final Coach coach) {
    this.coach = coach;
  }

  /* SETTER INJECTION EXAMPLE

  // Step 1: define a private field for dependency
  private Coach coach;

  // Step 2: Inject dependencies by calling any method on your class, simply give @Autowired
  @Autowired
  public void randomMethodName(@Qualifier("runningCoach") final Coach coach) {
    this.coach = coach;
  }
  */
  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return this.coach.getDailyWorkout();
  }
}
