package peaksoft.spring.repositroy.lessondao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Instructor;
import peaksoft.spring.models.Lesson;

import java.util.List;

public interface LessonDAO {

    List<Lesson> getAllLesson(Lesson lesson);

    void addLesson(Lesson lesson);

    Lesson getLessonByID(Long id);

    void updateLesson(Lesson lesson);

    void deleteLesson(Lesson lesson);

}
