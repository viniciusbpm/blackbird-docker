package br.com.cwi.blackbird.controller;

import br.com.cwi.blackbird.controller.request.AdicionarComentarioRequest;
import br.com.cwi.blackbird.controller.request.AdicionarPostRequest;
import br.com.cwi.blackbird.controller.request.IdUsuarioRequest;
import br.com.cwi.blackbird.controller.response.PostResponse;
import br.com.cwi.blackbird.domain.Comentario;
import br.com.cwi.blackbird.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private ListarPostsService listarPostsService;

    @Autowired
    private ListarPostsUsuarioService listarPostsUsuarioService;

    @Autowired
    private AdicionarPostService adicionarPostService;

    @Autowired
    private CurtirPostService curtirPostService;

    @Autowired
    private AdicionarComentarioService adicionarComentarioService;

    @Autowired
    private ListarComentariosPostService listarComentariosPostService;

    @GetMapping
    public Page<PostResponse> listar(Pageable pageable){
        return listarPostsService.listar(pageable);
    }

    @GetMapping("/{id}")
    public Page<PostResponse> listarPorUsuario(Pageable pageable, @PathVariable Long id){
        return listarPostsUsuarioService.listar(pageable, id);
    }

    @PostMapping("/{id}")
    public PostResponse adicionar(@PathVariable Long id, @RequestBody @Valid AdicionarPostRequest request){
        return adicionarPostService.adicionar(id, request);
    }

    @PutMapping("/{id}/curtir")
    public void curtir(@PathVariable Long id, @RequestBody @Valid IdUsuarioRequest request){
        curtirPostService.curtir(id, request);
    }

    @PutMapping("/{id}/comentar")
    public void comentar(@PathVariable Long id, @RequestBody @Valid AdicionarComentarioRequest request){
        adicionarComentarioService.adicionar(id, request);
    }

    @GetMapping("/{id}/comentarios")
    public List<Comentario> listarComentarios(@PathVariable Long id){
        return listarComentariosPostService.listar(id);
    }
}
