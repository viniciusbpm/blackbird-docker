package br.com.cwi.blackbird.security.repository;

import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<Usuario> findById(Long id);
}
