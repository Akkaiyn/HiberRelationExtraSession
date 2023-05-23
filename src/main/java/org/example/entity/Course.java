package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor


public class Course {
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
    sequenceName = "course_seq",
    allocationSize = 1)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate dateOfStart;
    private String imageLink;
    private String description;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "course",
            cascade = {CascadeType.REFRESH,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REMOVE
    })
    private List<Lesson> lessons;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", dateOfStart=" + dateOfStart +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
