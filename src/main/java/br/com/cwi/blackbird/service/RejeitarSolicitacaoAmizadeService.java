package br.com.cwi.blackbird.service;

import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import br.com.cwi.blackbird.domain.StatusSolicitacao;
import br.com.cwi.blackbird.repository.SolicitacaoAmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejeitarSolicitacaoAmizadeService {

    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;


    public void rejeitar(Long id){
        SolicitacaoAmizade solicitacao = solicitacaoAmizadeRepository.findById(id).get();

        solicitacaoAmizadeRepository.delete(solicitacao);
    }
}
