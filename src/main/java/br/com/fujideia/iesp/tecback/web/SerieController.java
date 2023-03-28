package br.com.fujideia.iesp.tecback.web;

import br.com.fujideia.iesp.tecback.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {
    @Autowired
    private SerieService service;
}
