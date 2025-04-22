package br.uniesp.si.techback.model.mapper;

import br.uniesp.si.techback.model.dto.UsuarioDTO;
import br.uniesp.si.techback.model.dto.UsuarioResponseDTO;
import br.uniesp.si.techback.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public Usuario toEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);
    }

    public UsuarioResponseDTO toDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponseDTO.class);
    }
}
