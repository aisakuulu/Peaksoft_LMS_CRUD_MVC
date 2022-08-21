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
    public List<Task> getAllTask(Task task) {
        return null;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public Task getTaskByID(Long id) {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }
}
