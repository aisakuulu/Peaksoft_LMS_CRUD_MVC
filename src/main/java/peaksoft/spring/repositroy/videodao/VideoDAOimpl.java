package peaksoft.spring.repositroy.videodao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Lesson;
import peaksoft.spring.models.Video;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VideoDAOimpl implements VideoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Video> getAllVideo(Long id) {
        return entityManager.createQuery
                ("select v FROM Video v WHERE v.lesson.id = :id", Video.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public void addVideo(Long lessonId, Video video) {
        Lesson lesson = entityManager.find(Lesson.class,lessonId);
        lesson.setVideo(video);
        video.setLesson(lesson);
        entityManager.persist(video);
    }

    @Override
    public Video getVideoByID(Long id) {
        return entityManager.find(Video.class, id);
    }

    @Override
    public void updateVideo(Long id, Video upVideo) {
        Video video = entityManager.find(Video.class,id);
        video.setVideoName(upVideo.getVideoName());
        video.setLink(upVideo.getLink());
        entityManager.merge(video);
    }

    @Override
    public void deleteVideo(Long id) {
        Video video = entityManager.find(Video.class, id);
        entityManager.remove(video);
    }
}
