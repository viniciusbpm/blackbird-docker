package br.com.cwi.blackbird.controller.response;


import br.com.cwi.blackbird.domain.Visualizacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponse {
    private Long id;
    private String autor;

    private String conteudo;
    private Long plays;
    private Visualizacao visualizacao;
    private LocalDateTime dataPostagem;
    private String midia;
}
