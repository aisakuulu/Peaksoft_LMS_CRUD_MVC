package peaksoft.spring.repositroy.instructordao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;

import java.util.List;

public interface InstructorDAO {

    List<Instructor> getAllInstructor(Instructor instructor);

    void addInstructor(Instructor instructor);

    Instructor getInstructorByID(Long id);

    void updateInstructor(Instructor instructor);

    void deleteInstructor(Instructor instructor);

}
