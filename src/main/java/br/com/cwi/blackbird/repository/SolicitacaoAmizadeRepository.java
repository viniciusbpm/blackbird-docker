package br.com.cwi.blackbird.repository;

import br.com.cwi.blackbird.domain.SolicitacaoAmizade;
import br.com.cwi.blackbird.domain.StatusSolicitacao;
import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoAmizadeRepository extends JpaRepository<SolicitacaoAmizade, Long> {

    List<SolicitacaoAmizade> findAllByDestinatarioEqualsAndStatusLike(Usuario destinatario, StatusSolicitacao statusSolicitacao);
}
