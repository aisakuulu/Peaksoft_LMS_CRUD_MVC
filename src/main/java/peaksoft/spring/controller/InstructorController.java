package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Instructor;
import peaksoft.spring.service.courseservice.CourseService;
import peaksoft.spring.service.instructorservice.InstructorService;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;
    private final CourseService courseService;

    public InstructorController(InstructorService instructorService, CourseService courseService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
    }
    @GetMapping("/showInstructors/{companyId}")
    public String getAllInstructors(@PathVariable("companyId") Long id,  Model model){
        model.addAttribute("atrInstructors", instructorService.getAllInstructor(id));
        model.addAttribute("companyId", id);
        model.addAttribute("instructors", courseService.getAllCourse(id));
        return "instructor/show-instructors";
    }
    @GetMapping("{companyId}/newInstructorForm")
    public String displayInstructorForm(@PathVariable("companyId") Long id,  Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("atrNewInstructor", instructor);
        model.addAttribute("companyId", id);
        return "instructor/new-instructor";
    }

    @PostMapping("{companyId}/saveNewInstructor")
    public String createInstructor(@PathVariable("companyId") Long id,
                                   @ModelAttribute("atrNewInstructor") Instructor instructor){
        instructorService.addInstructor(id, instructor);
        return "redirect:/instructors/showInstructors/ " + id;
    }

    @GetMapping("/displayUpdateForm/{instructorId}")
    public String displayInstructorEditForm(@PathVariable("instructorId") Long id, Model model){
        Instructor instructor = instructorService.getInstructorByID(id);
        model.addAttribute("editInstrAtr", instructor);
        model.addAttribute("companyId", instructor.getTheCompany().getId());
        return "instructor/edit-instructor";
    }

    @PostMapping("/{selectedCompanyId}/{instructorId}/saveUpdatedInstructor")
    public String updateInstructor(@PathVariable("selectedCompanyId") Long companyId,
                                   @PathVariable("instructorId") Long instructorId,
                                   @ModelAttribute("editInstrAtr") Instructor instructor){
        instructorService.updateInstructor(instructorId, instructor);
        return "redirect:/instructors/showInstructors/ " + companyId;
    }

    @PostMapping("/{instructorID}/{companyId}/delete")
    public String deleteInstructor(@PathVariable("companyId") Long companyId,
                                   @PathVariable("instructorID") Long instructorID){
        instructorService.deleteInstructor(instructorID);
        return "redirect:/instructors/showInstructors/ " + companyId;
    }

}
