package peaksoft.spring.repositroy.studentdao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOimpl implements StudentDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudent(Student student) {
        return null;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public Student getStudentByID(Long id) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }
}
