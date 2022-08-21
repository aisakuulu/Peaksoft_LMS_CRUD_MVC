package peaksoft.spring.repositroy.coursedao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;

import java.util.List;

public interface CourseDAO {


    List<Course> getAllCourse();

    void addCourse(Course course);

    Course getCourseByID(Long id);

    void updateCourse(Long id, Course course);

    void deleteCourse(Long id);

}
