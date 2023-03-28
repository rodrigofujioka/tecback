package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository repository;
}
