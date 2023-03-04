package br.com.cwi.blackbird.service.core;

import br.com.cwi.blackbird.domain.Amizade;
import br.com.cwi.blackbird.domain.Post;
import br.com.cwi.blackbird.repository.AmizadeRepository;
import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarAmizadeService {

    public static final String MENSAGEM_AMIZADE_INEXISTENTE = "Esses usuários não são amigos";

    @Autowired
    private AmizadeRepository amizadeRepository;

    public Amizade porUsuarios(Usuario primeiroUsuario, Usuario segundoUsuario) {

        List<Amizade> amizadesPrimeiroUsuario = amizadeRepository.
                findAllByPrimeiroUsuarioEqualsOrSegundoUsuarioEquals(primeiroUsuario, segundoUsuario);

        List<Amizade> amizadesInterseccao = amizadesPrimeiroUsuario.stream()
                .filter(amizade -> amizade.getPrimeiroUsuario().equals(segundoUsuario) || amizade.getSegundoUsuario().equals(segundoUsuario))
                .collect(Collectors.toList());

        if (!amizadesInterseccao.isEmpty()) {
            return amizadesInterseccao.stream().findFirst().get();
        } else throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_AMIZADE_INEXISTENTE);
    }
}
