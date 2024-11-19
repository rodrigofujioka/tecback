package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.model.dto.DiretorDTO;
import br.com.fujideia.iesp.tecback.repository.DiretorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiretorService {

    private final DiretorRepository diretorRepository;
    private final ModelMapper modelMapper;

    public DiretorService(DiretorRepository diretorRepository, ModelMapper modelMapper) {
        this.diretorRepository = diretorRepository;
        this.modelMapper = modelMapper;
    }

    public DiretorDTO criarDiretor(DiretorDTO diretorDTO) {
        Diretor diretor = modelMapper.map(diretorDTO, Diretor.class);
        Diretor diretorSalvo = diretorRepository.save(diretor);
        return modelMapper.map(diretorSalvo, DiretorDTO.class);
    }

    public Optional<DiretorDTO> buscarPorId(Long id) {
        return diretorRepository.findById(id)
                .map(diretor -> modelMapper.map(diretor, DiretorDTO.class));
    }

    public List<DiretorDTO> listarTodos() {
        return diretorRepository.findAll().stream()
                .map(diretor -> modelMapper.map(diretor, DiretorDTO.class))
                .collect(Collectors.toList());
    }

    public void deletarDiretor(Long id) {
        diretorRepository.deleteById(id);
    }
}
