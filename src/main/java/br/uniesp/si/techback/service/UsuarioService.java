package br.uniesp.si.techback.service;


import br.uniesp.si.techback.model.dto.UsuarioDTO;
import br.uniesp.si.techback.model.dto.UsuarioResponseDTO;
import br.uniesp.si.techback.model.mapper.UsuarioMapper;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponseDTO salvar(UsuarioDTO dto) {
        Usuario entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioDTO dto) {
        Usuario existente = buscarPorId(id);
        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setSenha(dto.getSenha());
        existente.setPerfil(dto.getPerfil());
        existente.setAtivo(dto.getAtivo());
        return mapper.toDTO(repository.save(existente));
    }

    public void deletar(Long id) {
        Usuario existente = buscarPorId(id);
        repository.delete(existente);
    }
}
