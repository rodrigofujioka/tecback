package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.model.dto.GeneroDTO;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository generoRepo;

    public List<GeneroDTO> listAll() {
        return generoRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<GeneroDTO> buscarPorId(Long id) {
        return generoRepo.findById(id)
                .map(this::convertToDTO);
    }

    public GeneroDTO createGenero(GeneroDTO generoDTO) {
        Genero genero = convertToEntity(generoDTO);
        return convertToDTO(generoRepo.save(genero));
    }

    public Optional<GeneroDTO> updateGenero(Long id, GeneroDTO generoDTO) {
        return generoRepo.findById(id).map(genero -> {
            genero.setNome(generoDTO.getDescricao());
            return convertToDTO(generoRepo.save(genero));
        });
    }

    public boolean deleteGenero(Long id) {
        if (generoRepo.existsById(id)) {
            generoRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private GeneroDTO convertToDTO(Genero genero) {
        return new GeneroDTO(
                genero.getId(),
                genero.getNome()
        );
    }

    private Genero convertToEntity(GeneroDTO generoDTO) {
        Genero genero = new Genero();
        genero.setId(generoDTO.getId());
        genero.setNome(generoDTO.getDescricao());
        return genero;
    }
}
