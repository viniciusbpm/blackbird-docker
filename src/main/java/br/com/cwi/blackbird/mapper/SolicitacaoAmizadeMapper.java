package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import br.com.cwi.blackbird.security.domain.Usuario;

import static br.com.cwi.blackbird.domain.StatusSolicitacao.PENDENTE;

public class SolicitacaoAmizadeMapper {
    public static SolicitacaoAmizade toEntity(Usuario remetente, Usuario destinatario){
        SolicitacaoAmizade entity = new SolicitacaoAmizade();
        entity.setRemetente(remetente);
        entity.setDestinatario(destinatario);
        entity.setStatus(PENDENTE);
        return entity;
    }
}
