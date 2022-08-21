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
    public List<Lesson> getAllLesson(Lesson lesson) {
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
    public void updateLesson(Lesson lesson) {

    }

    @Override
    public void deleteLesson(Lesson lesson) {

    }
}
