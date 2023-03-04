package br.com.cwi.blackbird.service.core;

import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarPostService {

    public static String MENSAGEM_POST_INEXISTENTE = "Post não encontrado";

    @Autowired
    private PostRepository postRepository;

    public Post porId(Long id){
        return
                postRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, MENSAGEM_POST_INEXISTENTE));
    }
}
