package br.com.cwi.blackbird.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdicionarComentarioRequest {
    private String conteudo;
    private Long usuarioId;
}
