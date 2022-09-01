package peaksoft.spring.service.studentservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Student;
import peaksoft.spring.repositroy.studentdao.StudentDAO;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudent(Long id) {
        return studentDAO.getAllStudent(id);
    }

    @Override
    public void addStudent(Long id, Student student) {
        studentDAO.addStudent(id, student);
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentDAO.getStudentByID(id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentDAO.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    public void addStudentToCourse(Long studentId, Long courseId) {
        studentDAO.addStudentToCourse(studentId, courseId);
    }
}
