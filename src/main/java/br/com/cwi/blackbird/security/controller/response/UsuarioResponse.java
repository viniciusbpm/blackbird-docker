package br.com.cwi.blackbird.security.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioResponse {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String artistaFavorito;
    private String imagem;
}