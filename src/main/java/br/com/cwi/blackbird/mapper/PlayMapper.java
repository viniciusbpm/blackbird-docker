package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.request.IdRequest;
import br.com.cwi.blackbird.domain.Play;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.security.domain.Usuario;

public class PlayMapper {
    public static Play toEntity(Usuario usuario, Post post){
        return Play.builder()
                .usuario(usuario)
                .post(post)
                .build();
    }
}
