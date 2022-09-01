package peaksoft.spring.repositroy.videodao;

import peaksoft.spring.models.Video;

import java.util.List;

public interface VideoDao {


    List<Video> getAllVideo(Long id);

    void addVideo(Long lessonId, Video video);

    Video getVideoByID(Long id);

    void updateVideo(Long id, Video video);

    void deleteVideo(Long id);

}
