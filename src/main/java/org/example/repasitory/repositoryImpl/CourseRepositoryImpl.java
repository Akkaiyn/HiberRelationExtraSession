package org.example.repasitory.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;
import org.example.repasitory.CourseRepository;
import org.example.util.HibernateConfig;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
  private final   EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveCourse(Course course) {
        return null;
    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public String updateCourse(Long id, Course course) {

        return null;
    }

    @Override
    public void deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Course with id: " + id + "was deleted");


    }

    @Override
    public Course getCourseByName(String name) {
        return null;
    }
}
