package org.example.service.serviceImpl;

import org.example.entity.Instructor;
import org.example.repasitory.InstructorRepository;
import org.example.repasitory.repositoryImpl.InstructorRepositoryImpl;
import org.example.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository = new InstructorRepositoryImpl();
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
        return instructorRepository.getInstructorByCourseId(courseId);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);

    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId,courseId);

    }
}
