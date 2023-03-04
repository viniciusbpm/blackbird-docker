package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import br.com.cwi.blackbird.domain.StatusSolicitacao;
import br.com.cwi.blackbird.mapper.AmizadeMapper;
import br.com.cwi.blackbird.mapper.SolicitacaoAmizadeMapper;
import br.com.cwi.blackbird.repository.AmizadeRepository;
import br.com.cwi.blackbird.repository.SolicitacaoAmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.blackbird.domain.StatusSolicitacao.ACEITA;
import static br.com.cwi.blackbird.mapper.AmizadeMapper.toEntity;

@Service
public class AceitarSolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;

    @Autowired
    private AmizadeRepository amizadeRepository;

    public void aceitar(Long id){
        SolicitacaoAmizade solicitacao = solicitacaoAmizadeRepository.findById(id).get();
        Amizade amizade = toEntity(solicitacao);

        solicitacao.setStatus(ACEITA);
        solicitacao.getDestinatario().adicionarAmigo(amizade);
        solicitacao.getRemetente().adicionarAmigo(amizade);

        amizadeRepository.save(amizade);
        solicitacaoAmizadeRepository.save(solicitacao);
    }
}
