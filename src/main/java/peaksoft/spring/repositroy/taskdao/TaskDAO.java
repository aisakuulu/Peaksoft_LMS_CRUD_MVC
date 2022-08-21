package peaksoft.spring.repositroy.taskdao;

import peaksoft.spring.models.Student;
import peaksoft.spring.models.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTask(Task task);

    void addTask(Task task);

    Task getTaskByID(Long id);

    void updateTask(Task task);

    void deleteTask(Task task);

}
