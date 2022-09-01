package peaksoft.spring.repositroy.studentdao;

import peaksoft.spring.models.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudent(Long id);

    void addStudent(Long companyId, Student student);

    Student getStudentByID(Long id);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    void addStudentToCourse(Long studentId,Long courseId);
}
