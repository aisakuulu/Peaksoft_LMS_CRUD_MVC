package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Course;
import peaksoft.spring.service.courseservice.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllCourses(Model model){
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("getAllCourses", courses);
        return "course/show-courses";
    }

    @GetMapping("/new")
    public String displayCourseForm(Model model){
        Course newCourse = new Course();
        model.addAttribute("addCourseAtr", newCourse);
        return "course/new-course";
    }

    @PostMapping("/save")
    public String createCourse(@ModelAttribute("addCourseAtr") Course course){
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/edit")
    public String displayCourseEditForm(@PathVariable("id") Long id, Model model){
        Course course = courseService.getCourseByID(id);
        model.addAttribute("courseInfo", course);
        return "/course/edit-course";
    }

    @PatchMapping("/{id}")
    public String updateCourse(@ModelAttribute("courseInfo") Course course,
                               @PathVariable("id") Long id){
        courseService.updateCourse(id, course);
        return "redirect:/courses";
    }

    @PostMapping("/delete/{courseID}")
    public String deleteCourse(@PathVariable Long courseID){
        courseService.deleteCourse(courseID);
        return "redirect:/courses";
    }
}
