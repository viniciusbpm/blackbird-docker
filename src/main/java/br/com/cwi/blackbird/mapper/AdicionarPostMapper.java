package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.request.AdicionarPostRequest;
import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Post;

public class AdicionarPostMapper {
    public static Post toEntity(AdicionarPostRequest request){
        Post entity = new Post();
        entity.setConteudo(request.getConteudo());
        entity.setMidia(request.getMidia());
        entity.setVisualizacao(request.getVisualizacao());
        entity.setQuantidadePlays(0L);
        return entity;
    }
}
