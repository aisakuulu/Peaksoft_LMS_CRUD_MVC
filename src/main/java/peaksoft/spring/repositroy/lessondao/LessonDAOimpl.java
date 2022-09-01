package peaksoft.spring.repositroy.lessondao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonDAOimpl implements LessonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getAllLesson(Long id) {
        return entityManager.createQuery
                ("SELECT l FROM Lesson l WHERE l.course.id = :id", Lesson.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public void addLesson(Long courseId, Lesson lesson) {
        Course course = entityManager.find(Course.class, courseId);
        course.addLessons(lesson);
        lesson.setCourse(course);
        entityManager.persist(lesson);
    }

    @Override
    public Lesson getLessonByID(Long id) {
        return entityManager.find(Lesson.class, id);
    }

    @Override
    public void updateLesson(Long id, Lesson upLesson) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        lesson.setLessonName(upLesson.getLessonName());
        lesson.setVideo(upLesson.getVideo());
        entityManager.merge(lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.remove(lesson);
    }
}
