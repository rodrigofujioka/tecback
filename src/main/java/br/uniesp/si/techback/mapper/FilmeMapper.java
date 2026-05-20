package br.uniesp.si.techback.mapper;

import br.uniesp.si.techback.dto.FilmeDTO;
import br.uniesp.si.techback.model.Filme;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    private final ModelMapper modelMapper;

    public FilmeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Filme toEntity(FilmeDTO dto) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, Filme.class);
    }

    public FilmeDTO toDTO(Filme entity) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, FilmeDTO.class);
    }
}
