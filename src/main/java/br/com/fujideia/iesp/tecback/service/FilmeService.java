package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme criarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Optional<Filme> atualizarFilme(Long id, Filme filmeDetalhes) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            filme.setTitulo(filmeDetalhes.getTitulo());
            filme.setAnoLancamento(filmeDetalhes.getAnoLancamento());
            filme.setDiretor(filmeDetalhes.getDiretor());
            filme.setAtores(filmeDetalhes.getAtores());
            filme.setGeneros(filmeDetalhes.getGeneros());
            Filme filmeAtualizado = filmeRepository.save(filme);
            return Optional.of(filmeAtualizado);
        } else {
            return Optional.empty();
        }
    }

    public boolean deletarFilme(Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
