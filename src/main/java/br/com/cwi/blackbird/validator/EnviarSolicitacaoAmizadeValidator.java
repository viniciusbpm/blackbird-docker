package br.com.cwi.blackbird.validator;

import br.com.cwi.blackbird.security.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class EnviarSolicitacaoAmizadeValidator {
    public static String MENSAGEM_USUARIO_IGUAL_REMETENTE = "O destinatário deve ser diferente do remetente";

    public void validar(Usuario destinatario, Usuario remetente){
        if(destinatario.equals(remetente)){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_USUARIO_IGUAL_REMETENTE);
        }
    }
}
