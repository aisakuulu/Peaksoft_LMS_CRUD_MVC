package peaksoft.spring.service.lessonservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Lesson;
import peaksoft.spring.repositroy.lessondao.LessonDAO;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private final LessonDAO lessonDAO;

    public LessonServiceImpl(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

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
