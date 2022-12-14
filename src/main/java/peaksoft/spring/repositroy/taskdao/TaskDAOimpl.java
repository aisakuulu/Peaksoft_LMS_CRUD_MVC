package peaksoft.spring.repositroy.taskdao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Lesson;
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
    public List<Task> getAllTask(Long id) {
        return entityManager.createQuery
                ("select t FROM Task t WHERE t.lesson.id = :id",
                        Task.class).setParameter("id", id).getResultList();
    }

    @Override
    public void addTask(Long lessonId, Task task) {
        Lesson lesson = entityManager.find(Lesson.class,lessonId);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(task);
    }

    @Override
    public Task getTaskByID(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void updateTask(Long id, Task upTask) {
        Task task = entityManager.find(Task.class, id);
        task.setTaskName(upTask.getTaskName());
        task.setTaskText(upTask.getTaskText());
        task.setDeadLine(upTask.getDeadLine());
        entityManager.merge(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
    }
}
