package peaksoft.spring.service.taskservice;

import peaksoft.spring.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTask(Task task);

    void addTask(Task task);

    Task getTaskByID(Long id);

    void updateTask(Task task);

    void deleteTask(Task task);
}
