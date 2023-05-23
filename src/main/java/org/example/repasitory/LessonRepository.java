package org.example.repasitory;

import org.example.entity.Lesson;

import java.util.List;

public interface LessonRepository {
    Lesson saveLesson(Long courseId, Lesson lesson);
    Lesson updateLesson(Long id, Lesson lesson);
    List<Lesson> getLessonByCourseId(String name);
    void deleteLessonByID(Long id);


}
