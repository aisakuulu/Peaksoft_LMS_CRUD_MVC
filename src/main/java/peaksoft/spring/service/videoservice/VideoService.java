package peaksoft.spring.service.videoservice;

import peaksoft.spring.models.Video;

import java.util.List;

public interface VideoService {


    List<Video> getAllVideo(Long id);

    void addVideo(Long lessonId, Video video);

    Video getVideoByID(Long id);

    void updateVideo(Long id, Video video);

    void deleteVideo(Long id);
}
