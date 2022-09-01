package peaksoft.spring.repositroy.studentdao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
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
    public List<Student> getAllStudent(Long id) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.theCompany.id = :id",
                Student.class).setParameter("id", id).getResultList();
    }

    @Override
    public void addStudent(Long companyId, Student student) {
        Company company = entityManager.find(Company.class, companyId);
        company.addStudent(student);
        student.setTheCompany(company);
        student.setStudyFormat(student.getStudyFormat());
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
        student.setCourse(null);
        entityManager.remove(student);
    }

    @Override
    public void addStudentToCourse(Long studentId, Long courseId) {
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);
        student.setCourse(course);
        course.addStudents(student);
        entityManager.merge(student);
    }
}
