package org.example.service;

import org.example.entity.Lesson;

import java.util.List;

public interface LessonService {
    Lesson saveLesson(Long courseId, Lesson lesson);
    Lesson updateLesson(Long id, Lesson lesson);
    List<Lesson> getLessonByCourseId(String name);
    void deleteLessonByID(Long id);
}
