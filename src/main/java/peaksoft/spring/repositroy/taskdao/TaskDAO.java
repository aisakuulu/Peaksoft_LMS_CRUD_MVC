package peaksoft.spring.repositroy.taskdao;

import peaksoft.spring.models.Student;
import peaksoft.spring.models.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTask();

    void addTask(Task task);

    Task getTaskByID(Long id);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);

}
