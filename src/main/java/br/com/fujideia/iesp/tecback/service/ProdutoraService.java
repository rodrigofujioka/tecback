package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.repository.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoraService {
    @Autowired
    private ProdutoraRepository repository;
}
