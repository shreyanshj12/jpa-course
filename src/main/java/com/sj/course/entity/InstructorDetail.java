package com.sj.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table
public class InstructorDetail {

  //steps
  //1. annotate the class as an entity and map to db table
  //2. define the fields
  //3. annotate the fields with db column name
  //4. create no args and all args constructor
  //5. generate getter/setter methods
  //6. generate toString() method

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, name = "id", length = 36)
  private UUID id;

  @Column(name = "youtube_channel", nullable = false)
  private String youtubeChannel;

  @Column(name = "hobby", nullable = false)
  private String hobby;

  @Override
  public String toString() {
    return "InstructorDetail{"
        + "id="
        + id
        + ", youtubeChannel='"
        + youtubeChannel
        + '\''
        + ", hobby='"
        + hobby
        + '\''
        + '}';
  }
}
