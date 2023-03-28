package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.service.ClassificacaoEtariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificacaoEtariaController {

    @Autowired
    private ClassificacaoEtariaService service;
}
