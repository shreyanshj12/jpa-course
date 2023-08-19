package com.sj.course.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "instructor")
public class Instructor {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, length = 36)
  private UUID id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  public Instructor(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  @Column(name = "email_address", nullable = false, unique = true)
  private String emailAddress;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "instructor_detail_id")
  private InstructorDetail instructorDetail;

  @Override
  public String toString() {
    return "Instructor{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", emailAddress='"
        + emailAddress
        + '\''
        + ", instructorDetail="
        + instructorDetail
        + '}';
  }
}
