package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.mapper.PostMapper;
import br.com.cwi.blackbird.repository.PostRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarAmizadeService;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPostsUsuarioService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private BuscarAmizadeService buscarAmizadeService;

    public Page<PostResponse> listar(Pageable pageable, Long id){

        Usuario usuario = buscarUsuarioService.porId(id);

        Page<Post> posts = postRepository.findAllByUsuarioEquals(pageable, usuario);

        return posts.map(PostMapper::toResponse);
    }
}
