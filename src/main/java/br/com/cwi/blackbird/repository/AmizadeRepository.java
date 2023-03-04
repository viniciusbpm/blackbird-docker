package br.com.cwi.blackbird.repository;

import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    List<Amizade> findAllByPrimeiroUsuarioEqualsOrSegundoUsuarioEquals(Usuario primeiroUsuario, Usuario segundoUsuario);

    boolean findByPrimeiroUsuarioEqualsOrSegundoUsuarioEquals(Usuario primeiroUsuario, Usuario segundoUsuario);
}
