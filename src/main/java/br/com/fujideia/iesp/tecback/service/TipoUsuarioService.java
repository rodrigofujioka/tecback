package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository repository;
}