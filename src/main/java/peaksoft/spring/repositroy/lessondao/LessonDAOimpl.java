package peaksoft.spring.repositroy.lessondao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LessonDAOimpl implements LessonDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lesson> getAllLesson() {
        return entityManager.createQuery
                ("SELECT les FROM Lesson les", Lesson.class).getResultList();
    }

    @Override
    public void addLesson(Lesson lesson) {
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
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.remove(lesson);
    }
}
