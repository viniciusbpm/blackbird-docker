package br.com.cwi.blackbird.security.service;

import br.com.cwi.blackbird.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.blackbird.security.controller.request.UsuarioRequest;
import br.com.cwi.blackbird.security.controller.response.UsuarioResponse;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.security.repository.UsuarioRepository;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.blackbird.security.mapper.UsuarioMapper.toResponse;
import static java.util.Objects.nonNull;

@Service
public class AlterarUsuarioService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioResponse alterar(Long id, AlterarUsuarioRequest request){
        Usuario usuario = buscarUsuarioService.porId(id);

        if(nonNull(request.getNomeCompleto())){
            usuario.setNomeCompleto(request.getNomeCompleto());
        }

        if(nonNull(request.getApelido())){
            usuario.setApelido(request.getApelido());
        }

        if(nonNull(request.getEmail())){
            usuario.setEmail(request.getEmail());
        }

        if(nonNull(request.getImagem())){
            usuario.setImagem(request.getImagem());
        }

        if(nonNull(request.getSenha())){
            usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        }

        if(nonNull(request.getArtistaFavorito())){
            usuario.setArtistaFavorito(request.getArtistaFavorito());
        }

        if(nonNull(request.getDataNascimento())){
            usuario.setDataNascimento(request.getDataNascimento());
        }

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
