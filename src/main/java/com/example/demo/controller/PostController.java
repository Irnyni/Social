package com.example.demo.controller;
import java.util.List;
import com.example.demo.entity.Postagem;
import com.example.demo.services.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Postagens")

public class PostController {

    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @GetMapping
    public List<Postagem> listar() {
        return postService.list();
    }

    @PostMapping
    public List<Postagem> create(@RequestBody Postagem postagem){
        return postService.create(postagem);
    }
    @PutMapping("/{id}")
    public Postagem atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagemAtualizada) {
        Postagem postagem = postService.atualizarPostagem(id, postagemAtualizada);
            return postagem;
        }

    @DeleteMapping("/{id}")

    public void deletarPostagems(@PathVariable Long id){

        postService.deletarPostagems(id);
    }

}
    


