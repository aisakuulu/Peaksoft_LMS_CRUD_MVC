package peaksoft.spring.service.taskservice;

import peaksoft.spring.models.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTask(Long id);

    void addTask(Long lessonId, Task task);

    Task getTaskByID(Long id);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);
}
