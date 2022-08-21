package peaksoft.spring.service.studentservice;

import peaksoft.spring.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(Student student);

    void addStudent(Student student);

    Student getStudentByID(Long id);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
