package peaksoft.spring.service.lessonservice;

import peaksoft.spring.models.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson();

    void addLesson(Lesson lesson);

    Lesson getLessonByID(Long id);

    void updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);

}
