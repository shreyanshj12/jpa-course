package com.sj.course;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
  @Override
  public String getDailyWorkout() {
    return "Practice backhand volley for 20 minutes";
  }
}
