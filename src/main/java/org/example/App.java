package org.example;

import org.example.entity.Lesson;
import org.example.service.CourseService;
import org.example.service.InstructorService;
import org.example.service.LessonService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.InstructorServiceImpl;
import org.example.service.serviceImpl.LessonServiceImpl;
import org.example.util.HibernateConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CourseService courseService = new CourseServiceImpl();
//        courseService.deleteCourseById(3L);
        InstructorService instructorService = new InstructorServiceImpl();
      // instructorService.assignInstructorToCourse(3L, 1L);
        //System.out.println(instructorService.getInstructorByCourseId(1L));
        //instructorService.deleteInstructorById(2L);

        LessonService lessonService = new LessonServiceImpl();
       // lessonService.saveLesson(1L, new Lesson("HTML", "html.videoLink"));
      //  System.out.println(lessonService.updateLesson(1L, new Lesson("CSS", "css.videoLink")));
       // System.out.println(lessonService.getLessonByCourseId("java"));

        lessonService.deleteLessonByID(2L);


    }
}
