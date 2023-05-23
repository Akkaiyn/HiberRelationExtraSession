package org.example.service.serviceImpl;

import org.example.entity.Course;
import org.example.repasitory.CourseRepository;
import org.example.repasitory.repositoryImpl.CourseRepositoryImpl;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository = new CourseRepositoryImpl();
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
        courseRepository.deleteCourseById(id);

    }

    @Override
    public Course getCourseByName(String name) {
        return null;
    }
}
