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
    public List<Instructor> getAllInstructor() {
        return null;
    }

    @Override
    public void addInstructor(Instructor instructor) {

    }

    @Override
    public Instructor getInstructorByID(Long id) {
        return null;
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {

    }

    @Override
    public void deleteInstructor(Long id) {

    }
}
