package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Course;
import peaksoft.spring.models.Student;
import peaksoft.spring.service.companyservice.CompanyService;
import peaksoft.spring.service.courseservice.CourseService;
import peaksoft.spring.service.studentservice.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final CompanyService companyService;

    public StudentController(StudentService studentService, CourseService courseService, CompanyService companyService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping("/showStudents/{companyId}")
    public String getAllStudents(@PathVariable("companyId") Long companyId,
                                 @ModelAttribute("course") Course course,
                                 Model model){
        model.addAttribute("atrStudents", studentService.getAllStudent(companyId));
        model.addAttribute("companyId", companyId);
        model.addAttribute("courses", courseService.getAllCourse(companyId));
        return "student/show-students";
    }

    @GetMapping("{companyId}/newStudentForm")
    public String displayStudentFrom(@PathVariable("companyId") Long id,  Model model){
        Student student = new Student();
        model.addAttribute("addNewStudent", student);
        model.addAttribute("companyId", id);
        return "student/new-student";
    }

    @PostMapping("{companyId}/saveNewCourse")
    public String createStudent(@PathVariable("companyId") Long companyId,
                                @ModelAttribute("addNewStudent") Student student){
        studentService.addStudent(companyId, student);
        return "redirect:/students/showStudents/ " + companyId;
    }

    @GetMapping("/displayUpdateForm/{studentId}")
    public String displayStudentEditForm(@PathVariable("studentId") Long studentId, Model model){
        Student student = studentService.getStudentByID(studentId);
        model.addAttribute("editStudentAtr", student);
        model.addAttribute("companyId", student.getTheCompany().getId());
        return "/student/edit-student";
    }

    @PostMapping("/{selectedCompanyId}/{studentId}/saveUpdatedStudent")
    public String updateStudent(@PathVariable("selectedCompanyId") Long companyId,
                                @PathVariable("studentId") Long studentId,
                                @ModelAttribute("editStudentAtr") Student student){
        studentService.updateStudent(studentId, student);
        return "redirect:/students/showStudents/ " + companyId;
    }

    @PostMapping("/{studentId}/{companyId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId,
                                @PathVariable("companyId") Long companyId){
        studentService.deleteStudent(studentId);
        return "redirect:/students/showStudents/ " + companyId;
    }

    @PostMapping("/{companyId}/{studentId}/assign")
    private String assignCourse(@PathVariable("studentId")Long id,
                          @PathVariable("companyId")Long companyId,
                          @ModelAttribute("course") Course course) {
        studentService.addStudentToCourse(id,course.getId());
        return "redirect:/students/showStudents/ "+ companyId;
    }
}
