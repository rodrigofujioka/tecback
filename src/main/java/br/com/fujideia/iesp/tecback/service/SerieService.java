package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
    @Autowired
    private SerieRepository repository;
}
