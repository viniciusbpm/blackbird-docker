package br.com.cwi.blackbird.controller.request;

import br.com.cwi.blackbird.domain.Visualizacao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AdicionarPostRequest {

    @NotBlank(message = "Post deve ter um conteúdo")
    private String conteudo;
    private String midia;
    @NotNull(message = "Post deve ter um tipo de visualização")
    private Visualizacao visualizacao;

}
