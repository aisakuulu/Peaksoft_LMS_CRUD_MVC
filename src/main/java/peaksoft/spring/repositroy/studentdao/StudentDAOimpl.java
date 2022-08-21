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
    public List<Student> getAllStudent() {
        return entityManager.createQuery("SELECT st FROM Student st", Student.class).getResultList();
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentByID(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Long id, Student upStudent) {
        Student student = entityManager.find(Student.class, id);
        student.setFirstName(upStudent.getFirstName());
        student.setLastName(upStudent.getLastName());
        student.setPhoneNumber(upStudent.getPhoneNumber());
        student.setEmail(upStudent.getEmail());
        student.setStudyFormat(upStudent.getStudyFormat());
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
