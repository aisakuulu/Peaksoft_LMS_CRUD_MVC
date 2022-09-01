package peaksoft.spring.repositroy.lessondao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;
import peaksoft.spring.models.Lesson;

import java.util.List;

public interface LessonDAO {

    List<Lesson> getAllLesson(Long id);

    void addLesson(Long courseId, Lesson lesson);

    Lesson getLessonByID(Long id);

    void updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);

}
