package com.example.demo.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Postagem;
import com.example.demo.repository.PostRepo;
@Service
public class PostService {
    private PostRepo postRepo;



    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<Postagem> create(Postagem post){
        postRepo.save(post);
        return list();
    }

    public List<Postagem> list(){
        return postRepo.findAll();
    }

    public Postagem atualizarPostagem(Long id, Postagem postagemAtualizada) {
         return postRepo.save(postagemAtualizada);

            
}

    public List<Postagem> deletarPostagems(Long id) {
       postRepo.deleteById(id);
       return list();
    }


}
