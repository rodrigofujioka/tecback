package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.model.dto.DiretorDTO;
import br.com.fujideia.iesp.tecback.repository.DiretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiretorService {

    private final DiretorRepository diretorRepo;

    public List<DiretorDTO> listarTodos() {
        return diretorRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Optional<DiretorDTO> buscarPorId(Long id) {
        return diretorRepo.findById(id)
                .map(this::convertToDTO);
    }

    public DiretorDTO createDiretor(DiretorDTO diretorDTO) {
        Diretor diretor = convertToEntity(diretorDTO);
        return convertToDTO(diretorRepo.save(diretor));
    }

    public Optional<DiretorDTO> updateDiretor(Long id, DiretorDTO diretorDTO) {
        return diretorRepo.findById(id).map(diretor -> {
            diretor.setNome(diretorDTO.getNome());
            return convertToDTO(diretorRepo.save(diretor));
        });
    }

    public boolean deleteDiretor(Long id) {
        if (diretorRepo.existsById(id)) {
            diretorRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private DiretorDTO convertToDTO(Diretor diretor) {
        return new DiretorDTO(
                diretor.getId(),
                diretor.getNome()
        );
    }

    private Diretor convertToEntity(DiretorDTO diretorDTO) {
        Diretor diretor = new Diretor();
        diretor.setId(diretorDTO.getId());
        diretor.setNome(diretorDTO.getNome());
        return diretor;
    }
}
