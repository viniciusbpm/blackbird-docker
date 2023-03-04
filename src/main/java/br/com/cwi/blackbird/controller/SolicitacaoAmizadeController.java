package br.com.cwi.blackbird.controller;

import br.com.cwi.blackbird.controller.request.EnviarSolicitacaoAmizadeRequest;
import br.com.cwi.blackbird.controller.response.UsuarioResumidoResponse;
import br.com.cwi.blackbird.service.AceitarSolicitacaoAmizadeService;
import br.com.cwi.blackbird.service.EnviarSolicitacaoAmizadeService;
import br.com.cwi.blackbird.service.ListarSolicitacoesAmizadeService;
import br.com.cwi.blackbird.service.RejeitarSolicitacaoAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoAmizadeController {

    @Autowired
    private ListarSolicitacoesAmizadeService listarSolicitacoesAmizadeService;

    @Autowired
    private EnviarSolicitacaoAmizadeService enviarSolicitacaoAmizadeService;

    @Autowired
    private AceitarSolicitacaoAmizadeService aceitarSolicitacaoAmizadeService;

    @Autowired
    private RejeitarSolicitacaoAmizadeService rejeitarSolicitacaoAmizadeService;

    @GetMapping("/{id}")
    public List<UsuarioResumidoResponse> listar(@PathVariable Long id){
        return listarSolicitacoesAmizadeService.listar(id);
    }

    @PostMapping("/{idRemetente}/enviar")
    public void enviar(@PathVariable Long idRemetente, @RequestBody @Valid EnviarSolicitacaoAmizadeRequest request){
        enviarSolicitacaoAmizadeService.enviar(idRemetente, request);
    }

    @PutMapping("/{id}/aceitar")
    public void aceitar(@PathVariable Long id){
        aceitarSolicitacaoAmizadeService.aceitar(id);
    }

    @PutMapping("/{id}/rejeitar")
    public void rejeitar(@PathVariable Long id){
        rejeitarSolicitacaoAmizadeService.rejeitar(id);
    }


}
