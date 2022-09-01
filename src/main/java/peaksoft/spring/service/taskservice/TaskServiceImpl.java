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
    public List<Task> getAllTask(Long id) {
        return taskDAO.getAllTask(id);
    }

    @Override
    public void addTask(Long id, Task task) {
        taskDAO.addTask(id, task);
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
