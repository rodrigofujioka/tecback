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

    private final DiretorRepository diretorRepository;

    public List<DiretorDTO> listarTodos() {
        return diretorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DiretorDTO> buscarPorId(Long id) {
        return diretorRepository.findById(id)
                .map(this::convertToDTO);
    }

    public DiretorDTO criarDiretor(DiretorDTO diretorDTO) {
        Diretor diretor = convertToEntity(diretorDTO);
        return convertToDTO(diretorRepository.save(diretor));
    }

    public Optional<DiretorDTO> atualizarDiretor(Long id, DiretorDTO diretorDTO) {
        return diretorRepository.findById(id).map(diretor -> {
            diretor.setNome(diretorDTO.getNome());
            return convertToDTO(diretorRepository.save(diretor));
        });
    }

    public boolean deletarDiretor(Long id) {
        if (diretorRepository.existsById(id)) {
            diretorRepository.deleteById(id);
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
        diretor.setNome(diretorDTO.getNome());
        return diretor;
    }
}
