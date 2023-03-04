package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.request.IdUsuarioRequest;
import br.com.cwi.blackbird.domain.Play;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.repository.PlayRepository;
import br.com.cwi.blackbird.repository.PostRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarPostService;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static br.com.cwi.blackbird.mapper.PlayMapper.toEntity;

@Service
public class CurtirPostService {

    public final int VALOR_POR_CURTIDA = 1;
    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PlayRepository playRepository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void curtir(Long idPost, IdUsuarioRequest request){
        Post post = buscarPostService.porId(idPost);

        Usuario usuario = buscarUsuarioService.porId(request.getIdUsuario());

        if(playRepository.existsByUsuarioEquals(usuario)){
            Play play = playRepository.findByUsuarioEqualsAndPostEquals(usuario, post);
            post.removerPlay(play);
            post.setQuantidadePlays(post.getQuantidadePlays() - VALOR_POR_CURTIDA);

            postRepository.save(post);
            playRepository.deleteById(play.getId());
        } else {
            Play play = toEntity(usuario, post);
            post.adicionarPlay(play);
            post.setQuantidadePlays(post.getQuantidadePlays() + VALOR_POR_CURTIDA);

            postRepository.save(post);
            playRepository.save(play);
        }
    }
}
