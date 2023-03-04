package br.com.cwi.blackbird.service.core;

import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarUsuarioService {

    public static String MENSAGEM_USUARIO_INEXISTENTE = "Usuário inexistente";

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario porId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIO_INEXISTENTE));
    }
}
