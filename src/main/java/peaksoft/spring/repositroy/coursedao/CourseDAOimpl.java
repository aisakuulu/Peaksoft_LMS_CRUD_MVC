package peaksoft.spring.repositroy.coursedao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOimpl implements CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAllCourse() {
        List<Course> courses = entityManager.createQuery("SELECT course FROM Course course",
                Course.class).getResultList();
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseByID(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Long id, Course upCourse) {
        entityManager.getTransaction().begin();
        Course course = getCourseByID(id);
        course.setCourseName(upCourse.getCourseName());
        course.setDateOfStart(upCourse.getDateOfStart());
        course.setDuration(upCourse.getDuration());
        course.setImage(upCourse.getImage());
        course.setDescription(upCourse.getDescription());
        entityManager.merge(course);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = getCourseByID(id);
        entityManager.remove(course);
    }
}
