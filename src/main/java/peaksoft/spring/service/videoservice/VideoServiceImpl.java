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
