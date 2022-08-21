package peaksoft.spring.service.studentservice;

import peaksoft.spring.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    void addStudent(Student student);

    Student getStudentByID(Long id);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
