package br.com.cwi.blackbird.mapper;

import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.domain.SolicitacaoAmizade;

public class AmizadeMapper {
    public static Amizade toEntity(SolicitacaoAmizade solicitacaoAmizade){
        return Amizade.builder()
                .primeiroUsuario(solicitacaoAmizade.getRemetente())
                .segundoUsuario(solicitacaoAmizade.getDestinatario())
                .build();
    }
}
