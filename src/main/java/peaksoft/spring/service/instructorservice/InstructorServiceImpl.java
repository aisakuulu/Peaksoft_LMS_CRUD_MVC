package peaksoft.spring.service.instructorservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;
import peaksoft.spring.repositroy.instructordao.InstructorDAO;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorDAO instructorDAO;

    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> getAllInstructor(Long id) {
        return instructorDAO.getAllInstructor(id);
    }

    @Override
    public void addInstructor(Long id, Instructor instructor) {
        instructorDAO.addInstructor(id, instructor);
    }

    @Override
    public Instructor getInstructorByID(Long id) {
        return instructorDAO.getInstructorByID(id);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDAO.updateInstructor(id, instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorDAO.deleteInstructor(id);
    }

    @Override
    public void addInstructorToCourse(Long instructorId, Long courseId) {
        instructorDAO.addInstructorToCourse(instructorId, courseId);
    }
}
