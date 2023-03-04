package br.com.cwi.blackbird.controller;

import br.com.cwi.blackbird.controller.response.AmigoResponse;
import br.com.cwi.blackbird.service.ListarAmizadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private ListarAmizadesService listarAmizadesService;

    @GetMapping("/{id}")
    public List<AmigoResponse> listar(@PathVariable Long id){
        return listarAmizadesService.listar(id);
    }


}
