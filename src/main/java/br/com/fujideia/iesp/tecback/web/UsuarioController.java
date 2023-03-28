package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;
}
