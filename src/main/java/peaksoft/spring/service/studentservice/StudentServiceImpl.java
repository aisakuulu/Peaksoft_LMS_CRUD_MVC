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
