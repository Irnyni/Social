package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Postagem;

public interface PostRepo extends JpaRepository<Postagem,Long> {

}
