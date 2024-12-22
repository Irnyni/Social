package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Video;
import com.example.demo.repository.VideoRepo;

@Service
public class VideoService {
    private VideoRepo videoRepo;

    public VideoService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    public List<Video> listar() {

        return videoRepo.findAll();

    }

    public Video criarvideo(Video video){
       
        return videoRepo.save(video);

    }

    public Video atualizarVideo(Long id,Video videoatt){

          return videoRepo.save(videoatt);

    }

    public void delete(Long id) {
        videoRepo.deleteById(id);
       
    }
    public Optional<Video> getVideoById(Long id){
        return videoRepo.findById(id);
       }
       }
    


