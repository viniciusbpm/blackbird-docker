package br.com.cwi.blackbird.repository;

import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findAllByPostEquals(Post post);
}
