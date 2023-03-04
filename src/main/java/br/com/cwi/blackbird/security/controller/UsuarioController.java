package br.com.cwi.blackbird.security.controller;

import br.com.cwi.blackbird.security.controller.request.AlterarUsuarioRequest;
import br.com.cwi.blackbird.security.controller.request.UsuarioRequest;
import br.com.cwi.blackbird.security.controller.response.UsuarioResponse;
import br.com.cwi.blackbird.security.service.AlterarUsuarioService;
import br.com.cwi.blackbird.security.service.CadastrarUsuarioService;
import br.com.cwi.blackbird.security.service.DeletarUsuarioService;
import br.com.cwi.blackbird.security.service.DetalharUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private AlterarUsuarioService alterarUsuarioService;

    @Autowired
    private DeletarUsuarioService deletarUsuarioService;

    @PostMapping
    public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioRequest request){
        return cadastrarUsuarioService.cadastrar(request);
    }

    @GetMapping("/{id}")
    public UsuarioResponse detalhar(@PathVariable Long id){
        return detalharUsuarioService.detalhar(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponse alterar(@PathVariable Long id, @RequestBody @Valid AlterarUsuarioRequest request){
        return alterarUsuarioService.alterar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        deletarUsuarioService.deletar(id);
    }
}
