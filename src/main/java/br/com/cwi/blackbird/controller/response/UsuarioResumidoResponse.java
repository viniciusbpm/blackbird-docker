package br.com.cwi.blackbird.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResumidoResponse {
    private Long id;

    private String nomeCompleto;
    private String artistaFavorito;
    private String imagem;
}
