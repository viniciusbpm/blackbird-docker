package br.com.cwi.blackbird.repository;

import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByUsuarioEquals(Pageable pageable, Usuario usuario);

}
