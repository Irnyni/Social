package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Postagem;
import com.example.demo.entity.Video;
import com.example.demo.services.VideoService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Videos")
public class VideoController {
    private VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
     @GetMapping
     public List<Video> listar() {
         return videoService.listar();
     }

     

     @PostMapping
     public Video criar(@RequestBody Video video) {
        return videoService.criarvideo(video);
         
     }

     @DeleteMapping("/{id}")
        public void delete (@PathVariable Long id){
            videoService.delete(id);

        }

     
     
     @PutMapping("/{id}")
     public Video editar(@PathVariable Long id, @RequestBody Video videoAntigo) {
         Video videoNovo= videoService.atualizarVideo(id, videoAntigo);
         return videoNovo;
         
     }
     
   @GetMapping("/{id}")
   public Optional<Video> getVideoById(@PathVariable Long id) {
       return videoService.getVideoById(id);
   }
   


}
