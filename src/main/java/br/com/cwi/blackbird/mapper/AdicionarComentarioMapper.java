package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.request.AdicionarComentarioRequest;
import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.security.domain.Usuario;

public class AdicionarComentarioMapper {
    public static Comentario toEntity(AdicionarComentarioRequest request, Usuario usuario){
        return Comentario.builder()
                .conteudo(request.getConteudo())
                .usuario(usuario)
                .build();
    }
}
