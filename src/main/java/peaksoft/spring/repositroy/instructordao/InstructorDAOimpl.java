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
        return entityManager.createQuery("SELECT inst FROM Instructor inst",
                Instructor.class).getResultList();
    }

    @Override
    public void addInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor getInstructorByID(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void updateInstructor(Long id, Instructor upInstructor) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.setFirstName(upInstructor.getFirstName());
        instructor.setLastName(upInstructor.getLastName());
        instructor.setSpecialization(upInstructor.getSpecialization());
        instructor.setPhoneNumber(upInstructor.getPhoneNumber());
        instructor.setEmail(upInstructor.getEmail());
        entityManager.merge(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);

    }
}
