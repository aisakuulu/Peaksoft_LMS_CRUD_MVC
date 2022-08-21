package peaksoft.spring.repositroy.taskdao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDAOimpl implements TaskDAO{

    @PersistenceContext
    private EntityManager entityManager;

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
