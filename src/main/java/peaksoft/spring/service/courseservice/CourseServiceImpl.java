package peaksoft.spring.service.courseservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.repositroy.coursedao.CourseDAO;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDAO.getAllCourse();
    }

    @Override
    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    @Override
    public Course getCourseByID(Long id) {
        return courseDAO.getCourseByID(id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDAO.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDAO.deleteCourse(id);
    }
}
