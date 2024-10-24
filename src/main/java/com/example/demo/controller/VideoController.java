package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Video;

import com.example.demo.services.VideoService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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
     
     @PutMapping("path/{id}")
     public String putMethodName(@PathVariable String id, @RequestBody String entity) {
         //TODO: process PUT request
         
         return entity;
     }
     

    


}
