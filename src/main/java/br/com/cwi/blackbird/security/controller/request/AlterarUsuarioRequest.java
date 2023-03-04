package br.com.cwi.blackbird.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class AlterarUsuarioRequest {
    private String nomeCompleto;

    @Email(message = "deve ser válido")
    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    @Size(min = 8, max = 128, message = "deve ter entre 8 e 128 caracteres")
    private String senha;

    private String artistaFavorito;

    private String imagem;
}
