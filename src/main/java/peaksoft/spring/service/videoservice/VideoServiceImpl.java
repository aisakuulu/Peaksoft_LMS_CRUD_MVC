package peaksoft.spring.service.videoservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Video;
import peaksoft.spring.repositroy.videodao.VideoDao;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    private final VideoDao videoDao;

    public VideoServiceImpl(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public List<Video> getAllVideo(Long id) {
        return videoDao.getAllVideo(id);
    }

    @Override
    public void addVideo(Long id, Video video) {
        videoDao.addVideo(id, video);
    }

    @Override
    public Video getVideoByID(Long id) {
        return videoDao.getVideoByID(id);
    }

    @Override
    public void updateVideo(Long id, Video video) {
        videoDao.updateVideo(id, video);
    }

    @Override
    public void deleteVideo(Long id) {
        videoDao.deleteVideo(id);
    }
}
