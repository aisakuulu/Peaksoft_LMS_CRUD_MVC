package peaksoft.spring.service.taskservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Task;
import peaksoft.spring.repositroy.taskdao.TaskDAO;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDAO taskDAO;

    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getAllTask() {
        return taskDAO.getAllTask();
    }

    @Override
    public void addTask(Task task) {
        taskDAO.addTask(task);
    }

    @Override
    public Task getTaskByID(Long id) {
        return taskDAO.getTaskByID(id);
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskDAO.updateTask(id, task);
    }

    @Override
    public void deleteTask(Long id) {
        taskDAO.deleteTask(id);
    }
}
