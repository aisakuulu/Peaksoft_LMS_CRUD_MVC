package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Course;
import peaksoft.spring.service.companyservice.CompanyService;
import peaksoft.spring.service.courseservice.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final CompanyService companyService;

    public CourseController(CourseService courseService, CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping("/showCourses/{companyId}")
    public String getAllCourses(@PathVariable("companyId") Long companyId, Model model){
        model.addAttribute("atrCourses", courseService.getAllCourse(companyId));
        model.addAttribute("companyId", companyId);
        return "course/show-courses";
    }

    @GetMapping("{companyId}/newCourseForm")
    public String displayCourseForm(@PathVariable("companyId") Long id, Model model){
        Course newCourse = new Course();
        model.addAttribute("addCourseAtr", newCourse);
        model.addAttribute("companyId", id);
        return "course/new-course";
    }

    @PostMapping("{companyId}/saveNewCourse")
    public String createCourse(@PathVariable("companyId") Long companyId,
                               @ModelAttribute("addCourseAtr") Course course){
        courseService.addCourse(companyId, course);
        return "redirect:/courses/showCourses/ "+companyId;
    }

    @GetMapping("/displayUpdateForm/{courseId}")
    public String displayCourseEditForm(@PathVariable("courseId") Long courseId, Model model){
        Course course = courseService.getCourseByID(courseId);
        model.addAttribute("editCourseAtr", course);
        model.addAttribute("companyId", course.getTheCompany().getId());
        return "/course/edit-course";
    }

    @PostMapping("/{selectedCompanyId}/{courseId}/saveUpdatedCourse")
    public String updateCourse(@PathVariable("selectedCompanyId") Long companyId,
                               @PathVariable("courseId") Long courseId,
                               @ModelAttribute("editCourseAtr") Course course){
        courseService.updateCourse(courseId, course);
        return "redirect:/courses/showCourses/" + companyId;
    }

    @PostMapping("/{courseId}/{companyId}/delete")
    public String deleteCourse(@PathVariable("courseId") Long courseId, @PathVariable("companyId") Long companyId){
        courseService.deleteCourse(courseId);
        return "redirect:/courses/showCourses/ " + companyId;
    }
}
