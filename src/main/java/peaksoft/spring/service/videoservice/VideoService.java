package peaksoft.spring.service.videoservice;

import peaksoft.spring.models.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAllVideo(Video video);

    void addVideo(Video video);

    Video getVideoByID(Long id);

    void updateVideo(Video video);

    void deleteVideo(Video video);
}
