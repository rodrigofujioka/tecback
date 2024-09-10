package br.com.fujideia.iesp.tecback.service;


import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Diretor;
import br.com.fujideia.iesp.tecback.model.Ator;
import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.model.dto.FilmeDTO;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FilmeServiceTest {

    @InjectMocks
    private FilmeService filmeService;

    @Mock
    private FilmeRepository filmeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldListarTodosOsFilmes() {
        Filme filme1 = new Filme();
        Filme filme2 = new Filme();
        List<Filme> filmes = Arrays.asList(filme1, filme2);

        when(filmeRepository.findAll()).thenReturn(filmes);

        List<FilmeDTO> result = filmeService.listarTodos();
        assertEquals(2, result.size());
        verify(filmeRepository, times(1)).findAll();
    }

    @Test
    void shouldBuscarFilmePorIdQuandoExistente() {
        Filme filme = new Filme();
        filme.setId(1L);
        filme.setTitulo("Javaloriano: A Ameaça do Código");
        filme.setAnoLancamento(2022);
        filme.setDiretor(new Diretor());
        filme.setAtores(Arrays.asList(new Ator(), new Ator()));
        filme.setGeneros(Arrays.asList(new Genero()));

        when(filmeRepository.findById(1L)).thenReturn(Optional.of(filme));

        Optional<FilmeDTO> result = filmeService.buscarPorId(1L);
        assertTrue(result.isPresent());
        assertEquals("Javaloriano: A Ameaça do Código", result.get().getTitulo());
        assertEquals(2022, result.get().getAnoLancamento());
        verify(filmeRepository, times(1)).findById(1L);
    }

    @Test
    void shouldRetornarVazioAoBuscarFilmePorIdInexistente() {
        when(filmeRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<FilmeDTO> result = filmeService.buscarPorId(1L);
        assertFalse(result.isPresent());
        verify(filmeRepository, times(1)).findById(1L);
    }

    @Test
    void shouldCriarNovoFilme() {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setTitulo("O Império Contra Java");

        Filme filme = new Filme();
        filme.setTitulo("O Império Contra Java");

        when(filmeRepository.save(any(Filme.class))).thenReturn(filme);

        FilmeDTO result = filmeService.criarFilme(filmeDTO);
        assertNotNull(result);
        assertEquals("O Império Contra Java", result.getTitulo());
        verify(filmeRepository, times(1)).save(any(Filme.class));
    }

    @Test
    void shouldAtualizarFilmeQuandoExistente() {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setTitulo("Javaloriano: O Retorno dos Jedi de Java");

        Filme filmeExistente = new Filme();
        filmeExistente.setId(1L);
        filmeExistente.setTitulo("Javaloriano: A Nova Esperança");

        Filme filmeAtualizado = new Filme();
        filmeAtualizado.setId(1L);
        filmeAtualizado.setTitulo("Javaloriano: O Retorno dos Jedi de Java");

        when(filmeRepository.findById(1L)).thenReturn(Optional.of(filmeExistente));
        when(filmeRepository.save(any(Filme.class))).thenReturn(filmeAtualizado);

        Optional<FilmeDTO> result = filmeService.atualizarFilme(1L, filmeDTO);
        assertTrue(result.isPresent());
        assertEquals("Javaloriano: O Retorno dos Jedi de Java", result.get().getTitulo());
        verify(filmeRepository, times(1)).findById(1L);
        verify(filmeRepository, times(1)).save(any(Filme.class));
    }

    @Test
    void shouldNaoAtualizarFilmeInexistente() {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setTitulo("Javaloriano: O Retorno dos Jedi de Java");

        when(filmeRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<FilmeDTO> result = filmeService.atualizarFilme(1L, filmeDTO);
        assertFalse(result.isPresent());
        verify(filmeRepository, times(1)).findById(1L);
    }

    @Test
    void shouldDeletarFilmeQuandoExistente() {
        when(filmeRepository.existsById(1L)).thenReturn(true);

        boolean result = filmeService.deletarFilme(1L);
        assertTrue(result);
        verify(filmeRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldNaoDeletarFilmeInexistente() {
        when(filmeRepository.existsById(1L)).thenReturn(false);

        boolean result = filmeService.deletarFilme(1L);
        assertFalse(result);
        verify(filmeRepository, times(0)).deleteById(1L);
    }
}
