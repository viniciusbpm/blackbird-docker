package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.request.AdicionarComentarioRequest;
import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.mapper.AdicionarComentarioMapper;
import br.com.cwi.blackbird.repository.ComentarioRepository;
import br.com.cwi.blackbird.repository.PostRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarPostService;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static br.com.cwi.blackbird.mapper.AdicionarComentarioMapper.toEntity;

@Service
public class AdicionarComentarioService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Transactional
    public void adicionar(Long id, AdicionarComentarioRequest request){
        Post post = buscarPostService.porId(id);

        Usuario usuario = buscarUsuarioService.porId(request.getUsuarioId());

        Comentario comentario = toEntity(request, usuario);
        comentario.setPost(post);

        post.adicionarComentario(comentario);

        comentarioRepository.save(comentario);
    }
}
