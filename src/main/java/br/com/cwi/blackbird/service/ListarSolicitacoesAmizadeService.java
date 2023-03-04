package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.response.UsuarioResumidoResponse;
import br.com.cwi.blackbird.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.cwi.blackbird.domain.StatusSolicitacao.PENDENTE;
import static br.com.cwi.blackbird.mapper.UsuarioResumidoMapper.toResponse;

@Service
public class ListarSolicitacoesAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public List<UsuarioResumidoResponse> listar(Long id){

        Usuario usuario = buscarUsuarioService.porId(id);

        return solicitacaoAmizadeRepository.findAllByDestinatarioEqualsAndStatusLike(usuario, PENDENTE)
                .stream()
                .map(solicitacao -> {
                    Usuario remetente = solicitacao.getRemetente();
                    return toResponse(remetente);
                })
                .collect(Collectors.toList());
    }
}
