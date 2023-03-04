package br.com.cwi.blackbird.repository;

import br.com.cwi.blackbird.domain.Play;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayRepository extends JpaRepository<Play, Long> {
    boolean existsByUsuarioEquals(Usuario usuario);
    Play findByUsuarioEqualsAndPostEquals(Usuario usuario, Post post);
}
