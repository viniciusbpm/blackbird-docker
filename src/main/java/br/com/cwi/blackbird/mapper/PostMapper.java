package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Post;

public class PostMapper {
    public static PostResponse toResponse(Post entity){
        PostResponse response = new PostResponse();
        response.setId(entity.getId());
        response.setConteudo(entity.getConteudo());
        response.setAutor(entity.getUsuario().getNomeCompleto());
        response.setPlays(entity.getQuantidadePlays());
        response.setMidia(entity.getMidia());
        response.setVisualizacao(entity.getVisualizacao());
        response.setDataPostagem(entity.getDataPostagem());
        return response;
    }
}
