package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.controller.response.UsuarioResumidoResponse;
import br.com.cwi.blackbird.security.domain.Usuario;

public class UsuarioResumidoMapper {
    public static UsuarioResumidoResponse toResponse(Usuario entity) {
        UsuarioResumidoResponse response = new UsuarioResumidoResponse();
        response.setId(entity.getId());
        response.setNomeCompleto(entity.getNomeCompleto());
        response.setArtistaFavorito(entity.getArtistaFavorito());
        response.setImagem(entity.getImagem());

        return response;
    }
}
