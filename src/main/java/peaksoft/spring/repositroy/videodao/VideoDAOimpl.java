package peaksoft.spring.repositroy.videodao;

import org.springframework.stereotype.Repository;
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
    public List<Video> getAllVideo(Video video) {
        return null;
    }

    @Override
    public void addVideo(Video video) {

    }

    @Override
    public Video getVideoByID(Long id) {
        return null;
    }

    @Override
    public void updateVideo(Video video) {

    }

    @Override
    public void deleteVideo(Video video) {

    }
}
