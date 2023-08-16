package com.sj.course;

import org.springframework.stereotype.Component;

@Component
public class RunningCoach implements Coach {
  @Override
  public String getDailyWorkout() {
    return "Practice running for 2km";
  }
}
