package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Instructor;
import peaksoft.spring.models.Lesson;
import peaksoft.spring.service.lessonservice.LessonService;

import java.util.List;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/showLessons/{courseId}")
    public String getAllLessons(@PathVariable("courseId") Long courseId,  Model model){
        model.addAttribute("atrLessons", lessonService.getAllLesson(courseId));
        model.addAttribute("courseId", courseId);
        return "lesson/show-lesson";
    }

    @GetMapping("{courseId}/newLessonForm")
    public String displayLessonForm(@PathVariable("courseId") Long id, Model model){
        Lesson lesson = new Lesson();
        model.addAttribute("atrNewLesson", lesson);
        model.addAttribute("courseId", id);
        return "lesson/new-lesson";
    }

    @PostMapping("{courseId}/saveNewLesson")
    public String createLesson(@PathVariable("courseId") Long id,
                               @ModelAttribute("atrNewLesson") Lesson lesson){
        lessonService.addLesson(id, lesson);
        return "redirect:/lessons/showLessons/ " + id;
    }

    @GetMapping("/displayUpdateForm/{lessonId}")
    public String showLessonEditForm(@PathVariable("lessonId") Long id, Model model){
        Lesson lesson = lessonService.getLessonByID(id);
        model.addAttribute("editLessonAtr", lesson);
        model.addAttribute("courseId", lesson.getCourse().getId());
        return "lesson/edit-lesson";
    }

    @PostMapping("/{selectedCourseId}/{lessonId}/saveUpdatedLesson")
    public String updateLesson(@PathVariable("selectedCourseId") Long courseId,
                               @PathVariable("lessonId") Long lessonId,
                               @ModelAttribute("editLessonAtr") Lesson lesson){
        lessonService.updateLesson(lessonId, lesson);
        return "redirect:/lessons/showLessons/ " + courseId;
    }

    @PostMapping("/{lessonId}/{courseId}/delete")
    public String deleteLesson(@PathVariable("courseId") Long courseId,
                                   @PathVariable("lessonId")Long lessonId){
        lessonService.deleteLesson(lessonId);
        return "redirect:/lessons/showLessons/ " + courseId;
    }
}
