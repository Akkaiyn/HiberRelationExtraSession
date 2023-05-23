package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue (generator = "instructor_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_gen",
    sequenceName = "instructor_seq",
    allocationSize = 1)
    private Long id;
    private String instructorName;
    private String email;
    private String phoneNumber;
    @ManyToMany(mappedBy = "instructors", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Course> courses;

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", instructorName='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
