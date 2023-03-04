package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.request.AdicionarPostRequest;
import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.mapper.AdicionarPostMapper;
import br.com.cwi.blackbird.mapper.PostMapper;
import br.com.cwi.blackbird.repository.PostRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import br.com.cwi.blackbird.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.blackbird.mapper.AdicionarPostMapper.toEntity;
import static br.com.cwi.blackbird.mapper.PostMapper.toResponse;

@Service
public class AdicionarPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private NowService nowService;

    @Transactional
    public PostResponse adicionar(Long id, AdicionarPostRequest request){
        Usuario autor = buscarUsuarioService.porId(id);

        Post post = toEntity(request);
        post.setUsuario(autor);
        post.setDataPostagem(nowService.getDateTime());

        postRepository.save(post);

        return toResponse(post);
    }
}
