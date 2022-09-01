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
    public List<Course> getAllCourse(Long id) {

        return entityManager.
                createQuery("SELECT c FROM Course c where c.theCompany.id = :id",Course.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public void addCourse(Long companyId, Course course) {
        Company company =entityManager.find(Company.class, companyId);
        company.addCourse(course);
        course.setTheCompany(company);
        entityManager.persist(course);
    }

    @Override
    public Course getCourseByID(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourse(Long id, Course upCourse) {
        Course course = entityManager.find(Course.class, id);
        course.setCourseName(upCourse.getCourseName());
//        course.setDateOfStart(upCourse.getDateOfStart());
        course.setDuration(upCourse.getDuration());
        course.setImage(upCourse.getImage());
        course.setDescription(upCourse.getDescription());
        entityManager.merge(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
