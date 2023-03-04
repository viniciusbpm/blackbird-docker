package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.response.AmigoResponse;
import br.com.cwi.blackbird.security.domain.Usuario;

public class AmigoMapper {
    public static AmigoResponse toResponse(Usuario amigo){
        AmigoResponse response = new AmigoResponse();
        response.setIdAmigo(amigo.getId());
        response.setNomeAmigo(amigo.getNomeCompleto());
        response.setFotoAmigo(amigo.getImagem());
        return response;
    }
}
