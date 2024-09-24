package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.model.dto.AtorDTO;
import br.com.fujideia.iesp.tecback.repository.AtorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AtorService {

    private final AtorRepository atorRepository;

    public List<AtorDTO> listarTodos() {
        return atorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public Optional<AtorDTO> buscarPorId(Long id) {
        return atorRepository.findById(id)
                .map(this::convertToDTO);
    }

    public AtorDTO criarAtor(AtorDTO atorDTO) {
        Ator ator = convertToEntity(atorDTO);
        return convertToDTO(atorRepository.save(ator));
    }

    public Optional<AtorDTO> atualizarAtor(Long id, AtorDTO atorDTO) {
        return atorRepository.findById(id).map(ator -> {
            ator.setNome(atorDTO.getNome());
            return convertToDTO(atorRepository.save(ator));
        });
    }

    public boolean deletarAtor(Long id) {
        if (atorRepository.existsById(id)) {
            atorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private AtorDTO convertToDTO(Ator ator) {
        return new AtorDTO(
                ator.getId(),
                ator.getNome()
        );
    }

    private Ator convertToEntity(AtorDTO atorDTO) {
        Ator ator = new Ator();
        ator.setId(atorDTO.getId());
        ator.setNome(atorDTO.getNome());
        return ator;
    }
}
