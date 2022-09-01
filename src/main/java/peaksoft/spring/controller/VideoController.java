package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Video;
import peaksoft.spring.service.videoservice.VideoService;

import java.util.List;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;


    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/showVideos/{lessonId}")
    public String getAllVideos(@PathVariable("lessonId") Long lessonId, Model model){
        model.addAttribute("allVideos",videoService.getAllVideo(lessonId));
        model.addAttribute("lesson",lessonId);
        return "video/show-videos";
    }

    @GetMapping("{lessonId}/newVideoForm")
    public String displayVideoForm(@PathVariable("lessonId") Long lessonId, Model model){
        Video video = new Video();
        model.addAttribute("atrNewVideo", video);
        model.addAttribute("lessonId",lessonId);
        return "video/new-video";
    }

    @PostMapping("{lessonId}/saveNewVideo")
    public String createVideo(@PathVariable("lessonId")Long lessonId,
                              @ModelAttribute("atrNewVideo") Video video){
        videoService.addVideo(lessonId, video);
        return "redirect:/videos/showVideos/ " + lessonId;
    }

    @GetMapping("/displayUpdateForm/{videoId}")
    public String displayVideoEditForm(@PathVariable("videoId") Long videoId,
                                       Model model){
        Video video = videoService.getVideoByID(videoId);
        model.addAttribute("editVideoAtr", video);
        model.addAttribute("lessonId", video.getLesson().getId());
        return "video/edit-video";
    }

    @PostMapping("/{selectedLessonId}/{videoId}/saveUpdatedVideo")
    public String updateVideo(@PathVariable("selectedLessonId") Long lessonId,
                              @PathVariable("videoId") Long videoId,
                              @ModelAttribute("editVideoAtr") Video video){
        videoService.updateVideo(videoId, video);
        return "redirect:/videos/showVideos/ " + lessonId;
    }

    @PostMapping("/{lessonId}/{videoId}/delete")
    public String deleteVideo(@PathVariable("lessonId") Long lessonId,
                              @PathVariable("videoId") Long videoId){
        videoService.deleteVideo(videoId);
        return "redirect:/videos/showVideos/ " + lessonId;
    }
}
