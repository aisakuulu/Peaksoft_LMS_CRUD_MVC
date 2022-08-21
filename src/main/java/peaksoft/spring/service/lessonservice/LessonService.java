package peaksoft.spring.service.lessonservice;

import peaksoft.spring.models.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson(Lesson lesson);

    void addLesson(Lesson lesson);

    Lesson getLessonByID(Long id);

    void updateLesson(Lesson lesson);

    void deleteLesson(Lesson lesson);

}
