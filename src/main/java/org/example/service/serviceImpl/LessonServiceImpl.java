package org.example.service.serviceImpl;

import org.example.entity.Lesson;
import org.example.repasitory.LessonRepository;
import org.example.repasitory.repositoryImpl.LessonRepositoryImpl;
import org.example.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    LessonRepository lessonRepository = new LessonRepositoryImpl();
    @Override
    public Lesson saveLesson(Long courseId, Lesson lesson) {
        return lessonRepository.saveLesson(courseId,lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return lessonRepository.updateLesson(id, lesson);
    }

    @Override
    public List<Lesson> getLessonByCourseId(String name) {
        return lessonRepository.getLessonByCourseId(name);
    }

    @Override
    public void deleteLessonByID(Long id) {
    lessonRepository.deleteLessonByID(id);
    }
}
