package org.example.repasitory.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repasitory.LessonRepository;
import org.example.util.HibernateConfig;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {
   EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Lesson saveLesson(Long courseId, Lesson lesson) {
        entityManager.getTransaction().begin();
        entityManager.persist(lesson);
        Course course = entityManager.find(Course.class, courseId);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();



        return lesson;
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(lesson.getLessonName() + " was set instead " + lesson1.getLessonName());
        return lesson1;
    }

    @Override
    public List<Lesson> getLessonByCourseId(String name) {
        entityManager.getTransaction().begin();
        List <Lesson> lessons = entityManager.createQuery("select c.lessons from Course c " +
                        "join Lesson l where c.courseName = :name ", Lesson.class)
                .setParameter("name", name).
                getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
    }

    @Override
    public void deleteLessonByID(Long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        lesson.getCourse().getLessons().remove(lesson);
        entityManager.remove(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Lesson with id: "+ lesson.getId() + "was successfully deleted.");


    }
}
