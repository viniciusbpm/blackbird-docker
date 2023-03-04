package br.com.cwi.blackbird.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class IdUsuarioRequest {
    @NotNull
    private Long idUsuario;
}
