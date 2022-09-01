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
    public List<Lesson> getAllLesson(Long id) {
        return lessonDAO.getAllLesson(id);
    }

    @Override
    public void addLesson(Long id, Lesson lesson) {
        lessonDAO.addLesson(id, lesson);
    }

    @Override
    public Lesson getLessonByID(Long id) {
        return lessonDAO.getLessonByID(id);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        lessonDAO.updateLesson(id, lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonDAO.deleteLesson(id);
    }
}
