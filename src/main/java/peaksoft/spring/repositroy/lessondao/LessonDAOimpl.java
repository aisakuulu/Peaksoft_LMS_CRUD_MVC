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
        return null;
    }

    @Override
    public void addLesson(Lesson lesson) {

    }

    @Override
    public Lesson getLessonByID(Long id) {
        return null;
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {

    }

    @Override
    public void deleteLesson(Long id) {

    }
}
