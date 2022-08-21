package peaksoft.spring.repositroy.studentdao;

import peaksoft.spring.models.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudent();

    void addStudent(Student student);

    Student getStudentByID(Long id);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
