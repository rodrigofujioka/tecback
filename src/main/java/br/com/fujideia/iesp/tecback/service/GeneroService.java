package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository repository;
}
