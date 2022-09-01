package peaksoft.spring.service.lessonservice;

import peaksoft.spring.models.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson(Long id);

    void addLesson(Long courseId, Lesson lesson);

    Lesson getLessonByID(Long id);

    void updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);

}
