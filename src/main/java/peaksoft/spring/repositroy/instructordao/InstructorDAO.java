package peaksoft.spring.repositroy.instructordao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;

import java.util.List;

public interface InstructorDAO {

    List<Instructor> getAllInstructor();

    void addInstructor(Instructor instructor);

    Instructor getInstructorByID(Long id);

    void updateInstructor(Long id, Instructor instructor);

    void deleteInstructor(Long id);

}
