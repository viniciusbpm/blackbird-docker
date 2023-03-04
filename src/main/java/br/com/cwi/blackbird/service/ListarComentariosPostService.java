package br.com.cwi.blackbird.service;


import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.repository.ComentarioRepository;
import br.com.cwi.blackbird.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarComentariosPostService {

    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> listar(Long id){
        Post post = buscarPostService.porId(id);

        return comentarioRepository.findAllByPostEquals(post);
    }
}
