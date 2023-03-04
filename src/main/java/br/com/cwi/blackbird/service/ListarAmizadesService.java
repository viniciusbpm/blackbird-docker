package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.response.AmigoResponse;
import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.mapper.AmigoMapper;
import br.com.cwi.blackbird.repository.AmizadeRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmizadesService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public List<AmigoResponse> listar(Long id){
        Usuario usuario = buscarUsuarioService.porId(id);

        List<Amizade> amizades = amizadeRepository.findAllByPrimeiroUsuarioEqualsOrSegundoUsuarioEquals(usuario, usuario);

        List<Usuario> amigos = amizades.stream()
                .map(amizade -> {
                 if(amizade.getPrimeiroUsuario().equals(usuario)){
                     return amizade.getSegundoUsuario();
                 } else return amizade.getPrimeiroUsuario();
                })
                .collect(Collectors.toList());

        return amigos.stream()
                .map(AmigoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
