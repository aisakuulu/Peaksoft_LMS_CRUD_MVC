package peaksoft.spring.repositroy.videodao;

import peaksoft.spring.models.Video;

import java.util.List;

public interface VideoDao {


    List<Video> getAllVideo(Video video);

    void addVideo(Video video);

    Video getVideoByID(Long id);

    void updateVideo(Video video);

    void deleteVideo(Video video);

}
