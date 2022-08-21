package peaksoft.spring.repositroy.studentdao;

import peaksoft.spring.models.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudent(Student student);

    void addStudent(Student student);

    Student getStudentByID(Long id);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
