package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.controller.request.EnviarSolicitacaoAmizadeRequest;
import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import br.com.cwi.blackbird.repository.SolicitacaoAmizadeRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import br.com.cwi.blackbird.service.core.BuscarUsuarioService;
import br.com.cwi.blackbird.validator.EnviarSolicitacaoAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.blackbird.mapper.SolicitacaoAmizadeMapper.toEntity;

@Service
public class EnviarSolicitacaoAmizadeService {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private EnviarSolicitacaoAmizadeValidator enviarSolicitacaoAmizadeValidator;

    @Transactional
    public void enviar(Long idRemetente, EnviarSolicitacaoAmizadeRequest request){
        Usuario remetente = buscarUsuarioService.porId(idRemetente);
        Usuario destinatario = buscarUsuarioService.porId(request.getIdDestinatario());

        enviarSolicitacaoAmizadeValidator.validar(remetente, destinatario);

        SolicitacaoAmizade solicitacao = toEntity(remetente, destinatario);

        remetente.adicionarSolicitacaoEnviada(solicitacao);
        destinatario.adicionarSolicitacaoRecebida(solicitacao);

        solicitacaoAmizadeRepository.save(solicitacao);
    }
}
