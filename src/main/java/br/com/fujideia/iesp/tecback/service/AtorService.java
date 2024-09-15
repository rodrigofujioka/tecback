package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.dto.AtorDTO;
import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import br.com.fujideia.iesp.tecback.repository.AtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtorService {

    private final AtorRepository atorRepo;

    public List<AtorDTO> listAll() {
        return atorRepo.findAll()
                .stream();

    }



}
