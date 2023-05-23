package org.example.service;

import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {
    String instructorSave(Instructor instructor);
    Instructor getInstructorById(Long id);
    Instructor updateInstructorById(Long id, Instructor instructor);

    List<Instructor> getInstructorByCourseId(Long courseId);
    void deleteInstructorById(Long id);
    void assignInstructorToCourse(Long instructorId, Long courseId);
}
