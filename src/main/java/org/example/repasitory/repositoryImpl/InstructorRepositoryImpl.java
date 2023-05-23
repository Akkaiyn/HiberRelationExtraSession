package org.example.repasitory.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repasitory.InstructorRepository;
import org.example.util.HibernateConfig;

import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String instructorSave(Instructor instructor) {
        return null;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return null;
    }

    @Override
    public Instructor updateInstructorById(Long id, Instructor instructor) {
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Instructor> instructors = entityManager.createQuery("select i from Instructor i " +
                        "join i.courses c where c.id = : courseId ", Instructor.class)
                .setParameter("courseId", courseId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor = entityManager.find(Instructor.class, id);
        for (int i = 0; i < instructor.getCourses().size(); i++) {
             instructor.getCourses().get(i).getInstructors().remove(instructor);
        }
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Instructor was deleted");
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(
                instructor.getInstructorName() + " assigned to " + course.getCourseName());

    }
}
