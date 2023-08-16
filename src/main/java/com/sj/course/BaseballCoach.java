package com.sj.course;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
  @Override
  public String getDailyWorkout() {
    return "Practice batting for 30 minutes";
  }
}
