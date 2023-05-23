package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@NoArgsConstructor

public class Task {

    @Id
    @GeneratedValue(generator = "task_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen",
            sequenceName = "task_seq",
            allocationSize = 1)

    private Long id;
    private String name;
    private LocalDate deadLine;
    private String taskDescription;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    private Lesson lesson;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadLine=" + deadLine +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
