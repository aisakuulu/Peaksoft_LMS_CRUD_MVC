package peaksoft.spring.repositroy.instructordao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorDAOimpl implements InstructorDAO{

    @PersistenceContext
    private EntityManager entityManager;

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
