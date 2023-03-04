package br.com.cwi.blackbird.security.service;

import br.com.cwi.blackbird.security.controller.request.UsuarioRequest;
import br.com.cwi.blackbird.security.controller.response.UsuarioResponse;
import br.com.cwi.blackbird.security.domain.Permissao;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.cwi.blackbird.security.domain.Funcao.USUARIO;
import static br.com.cwi.blackbird.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.blackbird.security.mapper.UsuarioMapper.toResponse;

@Service
public class CadastrarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidaEmailJaExisteService validaEmailJaExisteService;

    public UsuarioResponse cadastrar(UsuarioRequest request) {

        Usuario usuario = toEntity(request);

        validaEmailJaExisteService.validar(usuario);

        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.setAtivo(true);
        usuario.adicionarPermissao(getPermissaoPadrao());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }
}
