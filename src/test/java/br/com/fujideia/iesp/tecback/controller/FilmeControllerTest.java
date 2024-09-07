package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.service.FilmeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class FilmeControllerTest {

    @InjectMocks
    private FilmeController filmeController;

    @Mock
    private FilmeService filmeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ShouldListarTodosTest() {
        Filme filme1 = new Filme();
        Filme filme2 = new Filme();
        List<Filme> filmes = Arrays.asList(filme1, filme2);

        when(filmeService.listarTodos()).thenReturn(filmes);

        ResponseEntity<List<Filme>> response = filmeController.listarTodos();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(filmeService, times(1)).listarTodos();
    }

    @Test
    void ShouldBuscarPorIdTest_Found() {
        Filme filme = new Filme();
        when(filmeService.buscarPorId(1L)).thenReturn(Optional.of(filme));

        ResponseEntity<Filme> response = filmeController.buscarPorId(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filme, response.getBody());
        verify(filmeService, times(1)).buscarPorId(1L);
    }

    @Test
    void ShouldBuscarPorIdTest_NotFound() {
        when(filmeService.buscarPorId(1L)).thenReturn(Optional.empty());

        ResponseEntity<Filme> response = filmeController.buscarPorId(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).buscarPorId(1L);
    }

    @Test
    void ShouldCriarFilmeTest() {
        Filme filme = new Filme();
        when(filmeService.criarFilme(filme)).thenReturn(filme);

        ResponseEntity<Filme> response = filmeController.criarFilme(filme);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filme, response.getBody());
        verify(filmeService, times(1)).criarFilme(filme);
    }

    @Test
    void ShouldAtualizarFilmeTest_Found() {
        Filme filmeDetalhes = new Filme();
        Filme filmeAtualizado = new Filme();
        when(filmeService.atualizarFilme(1L, filmeDetalhes)).thenReturn(Optional.of(filmeAtualizado));

        ResponseEntity<Filme> response = filmeController.atualizarFilme(1L, filmeDetalhes);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(filmeAtualizado, response.getBody());
        verify(filmeService, times(1)).atualizarFilme(1L, filmeDetalhes);
    }

    @Test
    void ShouldAtualizarFilmeTest_NotFound() {
        Filme filmeDetalhes = new Filme();
        when(filmeService.atualizarFilme(1L, filmeDetalhes)).thenReturn(Optional.empty());

        ResponseEntity<Filme> response = filmeController.atualizarFilme(1L, filmeDetalhes);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).atualizarFilme(1L, filmeDetalhes);
    }

    @Test
    void ShouldDeletarFilmeTest_Found() {
        when(filmeService.deletarFilme(1L)).thenReturn(true);

        ResponseEntity<Void> response = filmeController.deletarFilme(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(filmeService, times(1)).deletarFilme(1L);
    }

    @Test
    void ShouldDeletarFilmeTest_NotFound() {
        when(filmeService.deletarFilme(1L)).thenReturn(false);

        ResponseEntity<Void> response = filmeController.deletarFilme(1L);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(filmeService, times(1)).deletarFilme(1L);
    }
}
