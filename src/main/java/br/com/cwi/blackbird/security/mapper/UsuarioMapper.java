package br.com.cwi.blackbird.security.mapper;

import br.com.cwi.blackbird.security.controller.request.UsuarioRequest;
import br.com.cwi.blackbird.security.controller.response.UsuarioResponse;
import br.com.cwi.blackbird.security.domain.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setApelido(request.getApelido());
        entity.setEmail(request.getEmail());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setSenha(request.getSenha());
        entity.setArtistaFavorito(request.getArtistaFavorito());
        entity.setImagem(request.getImagem());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(entity.getId());
        response.setNomeCompleto(entity.getNomeCompleto());
        response.setEmail(entity.getEmail());
        response.setApelido(entity.getApelido());
        response.setDataNascimento(entity.getDataNascimento());
        response.setArtistaFavorito(entity.getArtistaFavorito());
        response.setImagem(entity.getImagem());

        return response;
    }
}
