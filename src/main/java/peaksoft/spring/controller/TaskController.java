package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Task;
import peaksoft.spring.service.taskservice.TaskService;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/showTasks/{lessonId}")
    public String getAllTask(@PathVariable("lessonId") Long lessonId,  Model model){
        model.addAttribute("atrTask", taskService.getAllTask(lessonId));
        model.addAttribute("lessonId", lessonId);
        return "task/show-tasks";
    }

    @GetMapping("{lessonId}/newTaskForm")
    public String displayTaskForm(@PathVariable("lessonId") Long lessonId,  Model model){
        Task task = new Task();
        model.addAttribute("atrNewTask", task);
        model.addAttribute("lessonId", lessonId);
        return "task/new-task";
    }

    @PostMapping("{lessonId}/saveNewTask")
    public String createTask(@PathVariable("lessonId") Long lessonId,
                             @ModelAttribute("atrNewTask") Task task){
        taskService.addTask(lessonId, task);
        return "redirect:/tasks/showTasks/ " + lessonId;
    }

    @GetMapping("/displayUpdateForm/{taskId}")
    public String displayTaskEditForm(@PathVariable("taskId") Long taskId, Model model){
        Task task = taskService.getTaskByID(taskId);
        model.addAttribute("editTaskAtr", task);
        model.addAttribute("lessonId", task.getLesson().getId());
        return "task/edit-task";
    }

    @PostMapping("/{selectedLessonId}/{taskId}/saveUpdatedTask")
    public String updateTask(@PathVariable("selectedLessonId")Long lessonId,
                             @PathVariable("taskId")Long taskId,
                             @ModelAttribute("task")Task task){
        taskService.updateTask(taskId, task);
        return "redirect:/tasks/showTasks/ " + lessonId;
    }

    @PostMapping("/{lessonId}/{taskId}/delete")
    public String deleteTask(@PathVariable("lessonId") Long lessonId,
                             @PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
        return "redirect:/tasks/showTasks/ " + lessonId;
    }
}
