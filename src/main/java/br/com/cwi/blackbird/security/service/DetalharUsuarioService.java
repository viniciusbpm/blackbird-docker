package br.com.cwi.blackbird.security.service;

import br.com.cwi.blackbird.security.controller.response.UsuarioResponse;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.blackbird.security.mapper.UsuarioMapper.toResponse;

@Service
public class DetalharUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public UsuarioResponse detalhar(Long id){
        Usuario usuario = buscarUsuarioService.porId(id);

        return toResponse(usuario);
    }
}
