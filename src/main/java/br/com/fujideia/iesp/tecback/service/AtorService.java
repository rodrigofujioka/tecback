package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.dto.AtorDTO;
import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import br.com.fujideia.iesp.tecback.repository.AtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AtorService {

    private final AtorRepository atorRepo;

    public List<AtorDTO> listAll() {
        return atorRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AtorDTO> buscarPorId (Long id) {
        return atorRepo.findById(id).map(this::convertToDTO);
    }

    public AtorDTO createAtor(AtorDTO atorDTO) {
        Ator ator = convertToEntity(atorDTO);
        return convertToDTO(atorRepo.save(ator));
    }

    public AtorDTO updateAtor(Long id, AtorDTO atorDTO) {
        return atorRepo.findById(id).map(ator -> {
            ator.setNome(atorDTO.getNome());
            ator.setFilmes(atorDTO.getFilmes().stream().map(this::convertToEntity).collect(Collectors.toList()));
            return convertToDTO(atorRepo.save(ator));
        }).orElseThrow(() -> new IllegalArgumentException("Ator não encontrado."));
    }

    public boolean deleteAtor(Long id) {
        if (atorRepo.existsById(id)) {
            atorRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private AtorDTO convertToDTO(Ator ator) {
        return new AtorDTO(
                ator.getId(),
                ator.getNome(),
                ator.getFilmes() != null ? ator.getFilmes().stream()
                        .map(filme -> new FilmeDTO(filme.getId(), filme.getTitulo(), filme.getAnoLancamento(), null, null, null))
                        .collect(Collectors.toList()) : null
        );
    }

    private Ator convertToEntity(AtorDTO atorDTO) {
        Ator ator = new Ator();
        ator.setId(atorDTO.getId());
        ator.setNome(atorDTO.getNome());
        ator.setFilmes(atorDTO.getFilmes() != null ? atorDTO.getFilmes().stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList()) : null);
        return ator;
    }

    private Filme convertToEntity(FilmeDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setId(filmeDTO.getId());
        filme.setTitulo(filmeDTO.getTitulo());
        filme.setAnoLancamento(filmeDTO.getAnoLancamento());
        return filme;
    }
}
