package br.com.cwi.blackbird.security.service;

import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.security.repository.UsuarioRepository;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;


    public void deletar(Long id) {
        Usuario usuario = buscarUsuarioService.porId(id);

        usuarioRepository.deleteById(id);
    }
}
